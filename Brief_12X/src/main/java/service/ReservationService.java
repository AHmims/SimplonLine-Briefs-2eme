package service;

import beans.DemandeReservation;
import config.Hibernate;
import dao.CalendrierDao;
import dao.ReservationDao;
import model.Apprenant;
import model.Calendrier;
import model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.api.ServiceReservation;

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
    public int validate(String idReservation, String action) {
        try {
             /*
            ERROR CODES:
            -1: unknown
            40: learner deleted
            41: learner not deleted
            42: learner updated / validated
            43: learner not updated / validated
            400: learner not found
             */
            ReservationDao reservationDao = new ReservationDao();
            Reservation reservation = reservationDao.get(idReservation);
            if (reservation == null)
                return 400;
            //
            if (action.equals("ok")) {
                //update / validate
                reservation.setValideReservation(true);
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

    //
    @Override
    public List<Reservation> getByCalendrier(String idCalendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
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
            CalendrierDao calendrierDao = new CalendrierDao();
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
            CalendrierDao calendrierDao = new CalendrierDao();
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
            CalendrierDao calendrierDao = new CalendrierDao();
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
    public List<Reservation> getByLastCalendrier() {
        try {
            CalendrierDao calendrierDao = new CalendrierDao();
            ArrayList<Calendrier> calendriers = calendrierDao.getAll();
            if (calendriers.size() == 0 || calendriers == null)
                return null;
            Calendrier calendrier = calendriers.get(calendriers.size() - 1);
            //
            return getByCalendrier(calendrier, true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
