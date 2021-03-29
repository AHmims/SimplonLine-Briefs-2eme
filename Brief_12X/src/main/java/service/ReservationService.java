package service;

import beans.DemandeReservation;
import config.Hibernate;
import dao.CalendrierDao;
import dao.EmplacementDao;
import dao.LocalDao;
import dao.ReservationDao;
import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.api.ServiceReservation;
import util.Parser;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationService implements ServiceReservation {

    @Override
    public ArrayList<Reservation> getAll(boolean status) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) session.createQuery("FROM Reservation WHERE valideReservation = :status").setParameter("status", status).list());
            transaction.commit();
            //
            return reservations;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<DemandeReservation> getRequests() {
        try {
            ArrayList<Reservation> reservations = getAll(false);
            if (reservations == null)
                return null;
            //
            ArrayList<DemandeReservation> demandeReservations = new ArrayList<>();
            for (Reservation reservation : reservations) {
                Calendar cal_res = Calendar.getInstance();
                cal_res.setTime(reservation.getDateReservation());
                int day = cal_res.get(Calendar.DAY_OF_WEEK);
                int nature = day >= Calendar.MONDAY && day <= Calendar.FRIDAY ? 1 : 2;
                demandeReservations.add(new DemandeReservation(reservation, getByCalendrierForLearner(reservation.getApprenant(), reservation.getCalendrier(), true).size(), nature));
            }
            return demandeReservations;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int validate(Administrateur administrateur, String idReservation, String action) {
        try {
             /*
            ERROR CODES:
            -1: unknown
            40: learner deleted
            41: learner not deleted
            42: learner updated / validated
            43: learner not updated / validated
            400: learner not found
            401: admin not found
             */
            if (administrateur == null)
                return 401;
            ReservationDao reservationDao = new ReservationDao();
            Reservation reservation = reservationDao.get(idReservation);
            if (reservation == null)
                return 400;
            //
            if (action.equals("ok")) {
                //update / validate
                reservation.setValideReservation(true);
                reservation.setAdministrateur(administrateur);
                boolean updateRes = reservationDao.update(reservation);
                return updateRes ? 42 : 43;
            } else {
                //delete
                boolean deleteRes = reservationDao.delete(reservation);
                return deleteRes ? 40 : 41;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int insert(Apprenant apprenant, String str_date, String idEmplacement, String idLocal) {
        try {
            /*
            ERROR CODES:
            -1: unknown
            50: inserted
            51: not inserted
            500: learner(apprenant) not found
            501: emplacement not found
            502: local not found
            503: date format is invalid
            504: no calendar exists in the date given
            505: already booked for this date, choose another date
            506: already have a reservation in waiting for validation
            507: queue filled for the provided date
             */
            //
            if (apprenant == null)
                return 500;
            //
            EmplacementDao emplacementDao = new EmplacementDao();
            Emplacement emplacement = emplacementDao.get(idEmplacement);
            if (emplacement != null) {
                LocalDao localDao = new LocalDao();
                Local local = localDao.get(idLocal);
                if (local != null) {
                    Date date = Parser.toDate(str_date);
                    if (date != null) {
                        CalendrierService calendrierService = new CalendrierService();
                        Calendrier calendrier = calendrierService.getByDate(date);
                        if (calendrier != null) {
                            Reservation pre_reservation = getByDateForUser(apprenant, date);
                            if (pre_reservation == null) {
                                boolean resCanReserve = canReserve(date, calendrier);
                                if (resCanReserve) {
                                    Reservation reservation = new Reservation(new Date(), date, apprenant, calendrier, emplacement);
                                    ReservationDao reservationDao = new ReservationDao();
                                    String insertRes = reservationDao.insert(reservation);
                                    return insertRes != null && !insertRes.equals("") ? 50 : 51;
                                } else return 507;
                            } else {
                                return pre_reservation.isValideReservation() ? 505 : 506;
                            }
                        } else return 504;
                    } else return 503;
                } else return 502;
            } else return 501;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int cancel(Apprenant apprenant) {
        try {
            /*
            ERROR CODES:
            -1: unknown
            60: reservation cancelled
            61: reservation not cancelled
            600: learner not found
            601: reservation not found
            602: reservation already validated

            */
            if (apprenant == null)
                return 600;
            //
            Reservation reservation = getLastReservationByUser(apprenant);
            if (reservation != null) {
                if (!reservation.isValideReservation()) {
                    ReservationDao reservationDao = new ReservationDao();
                    return reservationDao.delete(reservation) ? 60 : 61;
                } else return 602;
            } else return 601;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Reservation> getHistory(Apprenant apprenant, String type) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("FROM Reservation WHERE apprenant = :app AND valideReservation = true");
            query.setParameter("app", apprenant);
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) query.list());
            transaction.commit();
            //
            if (type.equals("all"))
                return reservations;
            else {
                int count = reservations.size();
                for (int i = 0; i < count; i++) {
                    Reservation reservation = reservations.get(i);
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(reservation.getDateReservation());
                    int day = cal.get(Calendar.DAY_OF_WEEK);
                    if (type.equals("week")) {
                        if (day >= 7 || day <= 1) {
                            reservations.remove(reservation);
                            count--;
                        }
                    } else {
                        if (day < 7 && day > 1) {
                            reservations.remove(reservation);
                            count--;
                        }
                    }
                }
                //
                return reservations;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
            return null;
        }
    }

    //
    @Override
    public List<Reservation> getByCalendrier(String idCalendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openNewSession();
            transaction = session.beginTransaction();
            //
            CalendrierDao calendrierDao = new CalendrierDao();
            //
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) session.createQuery("FROM Reservation WHERE calendrier = :cal AND valideReservation = true").setParameter("cal", calendrierDao.get(idCalendrier)).list());
            transaction.commit();
            //
            return reservations;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getByCalendrier(Calendrier calendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) session.createQuery("FROM Reservation WHERE calendrier = :cal").setParameter("cal", calendrier).list());
            transaction.commit();
            //
            return reservations;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getByCalendrier(Calendrier calendrier, boolean status) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("FROM Reservation WHERE calendrier = :cal AND valideReservation = :status");
            query.setParameter("cal", calendrier);
            query.setParameter("status", status);
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) query.list());
            transaction.commit();
            //
            return reservations;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getByCalendrierForLearner(Apprenant apprenant, Calendrier calendrier, boolean status) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("FROM Reservation WHERE calendrier = :cal AND valideReservation = :status AND apprenant = :apprenant");
            query.setParameter("cal", calendrier);
            query.setParameter("status", status);
            query.setParameter("apprenant", apprenant);
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) query.list());
            transaction.commit();
            //
            return reservations;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getByFirstCalendrier() {
        try {
            CalendrierDao calendrierDao = new CalendrierDao();
            ArrayList<Calendrier> calendriers = calendrierDao.getAll();
            if (calendriers.size() == 0 || calendriers == null)
                return null;
            Calendrier calendrier = calendriers.get(0);
            //
            return getByCalendrier(calendrier, true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean canReserve(Date date, Calendrier calendrier) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            //
            JourService jourService = new JourService();
            Jour jour = jourService.get(cal.get(Calendar.DAY_OF_WEEK), calendrier);
            if (jour != null) {
                List<Reservation> reservations = getByDate(date);
                if (reservations != null)
                    return reservations.size() < jour.getNbMaxReservations();
                return false;
            } else return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Reservation getByDateForUser(Apprenant apprenant, Date date) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("FROM Reservation WHERE apprenant = :app AND dateReservation = :date");
            query.setParameter("app", apprenant);
            query.setParameter("date", date);
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) query.list());
            transaction.commit();
            //
            return reservations.size() > 0 ? reservations.get(0) : null;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Reservation getLastReservationByUser(Apprenant apprenant) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("FROM Reservation WHERE apprenant = :app ORDER BY dateCreation desc");
            query.setParameter("app", apprenant);
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) query.list());
            transaction.commit();
            //
            return reservations.size() > 0 ? reservations.get(0) : null;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getByDate(Date date) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) session.createQuery("FROM Reservation WHERE dateReservation = :date").setParameter("date", date).list());
            transaction.commit();
            //
            return reservations;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

}
