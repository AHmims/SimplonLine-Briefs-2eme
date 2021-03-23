package service;

import config.Hibernate;
import dao.CalendrierDao;
import model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.api.ServiceReservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationService implements ServiceReservation {
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
}
