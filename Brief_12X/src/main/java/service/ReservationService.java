package service;

import config.Hibernate;
import dao.CalendrierDao;
import model.Calendrier;
import model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.api.ServiceReservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService implements ServiceReservation {

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
            ArrayList<Reservation> reservations = new ArrayList<>((List<Reservation>) session.createQuery("FROM Reservation WHERE calendrier = :cal").setParameter("cal", calendrierDao.get(idCalendrier)).list());
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
}
