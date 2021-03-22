package service;

import config.Hibernate;
import dao.JourDao;
import model.Administrateur;
import model.Calendrier;
import model.Jour;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.api.ServiceCalendrier;
import util.Validator;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CalendrierService implements ServiceCalendrier {
    @Override
    public int insert(Map<String, String> requestParams, Administrateur administrateur) {
        /*
        ERROR CODES:
        -1: unknown
        20: "Calendrier" entered successfully
        200: form inputs can't be empty
        201: inputs can't have alphabets, use numbers instead
        202: numbers can't be negative && can't be double
        203: date is not valid
        204: date interval does not match 7 days
        205: interval already exists in DB
        206: error saving "Jour" record or "Calendrier"
        ---
         */
        try {
            boolean valid = true;
            //check if inputs have a value or not
            for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                if (entry.getValue().isEmpty()) {
                    valid = false;
                    break;
                }
            }
            //
            if (valid) {
                //check if days have numbers
                for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                    if (!entry.getKey().equals("d-debut") && !entry.getKey().equals("d-fin")) {
                        if (!Validator.isNumeric(entry.getValue())) {
                            valid = false;
                            break;
                        }
                    }
                }
                //
                if (valid) {
                    for (Map.Entry<String, String> entry : requestParams.entrySet()) {
                        if (!entry.getKey().equals("d-debut") && !entry.getKey().equals("d-fin")) {
                            double entrey_nb = Double.parseDouble(entry.getValue());
                            if (entrey_nb < 0 || entrey_nb % 1 == 0) {
                                valid = false;
                                break;
                            }
                        }
                    }
                    if (valid) {
                        Date dateDebut = Validator.toDate(requestParams.get("d-debut"));
                        Date dateFin = Validator.toDate(requestParams.get("d-fin"));
                        if (dateDebut == null || dateFin == null)
                            return 203;
                        else {
                            LocalDate ld_DD = dateDebut.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            LocalDate ld_DF = dateFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                            long daysInBetween = ChronoUnit.DAYS.between(ld_DD, ld_DF) + 1;
                            if (daysInBetween == 7) {
                                //Check if there is an existing date in DB
                                valid = !exists(dateDebut);
                                if (valid) {
                                    //Crate Calendrier object
                                    Calendrier calendrier = new Calendrier(dateDebut, dateFin, administrateur);
                                    JourDao jourDao = new JourDao();
                                    for (int i = 0; i < daysInBetween; i++) {
                                    /*
                                    1: sunday
                                    ...
                                    7: saturday
                                     */
                                        Object key = requestParams.keySet().toArray()[i];
                                        int nbMax = Integer.parseInt(requestParams.get(key));
                                        //
                                        LocalDate DD_clone = ld_DD.plusDays(i + 1);
                                        Calendar cal = Calendar.getInstance();
                                        cal.setTime(Date.from(DD_clone.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                                        //
                                        String insertRes = jourDao.insert(new Jour(cal.get(Calendar.DAY_OF_WEEK), nbMax, calendrier));
                                        if (insertRes.equals("") || insertRes == null) {
                                            valid = false;
                                            break;
                                        }
                                    }
                                    //
                                    if (valid) {
                                        return 20;
                                    } else return 206;
                                } else return 205;
                            } else return 204;
                        }
                    } else return 202;
                } else return 201;
            } else return 200;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean exists(Date date) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Calendrier> calendriers = new ArrayList<>((List<Calendrier>) session.createQuery("FROM Calendrier WHERE :date BETWEEN dateDebut AND dateFin").setParameter("date", date).list());
            transaction.commit();
            //
            return calendriers.size() > 0;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return true;
        }
    }
}
