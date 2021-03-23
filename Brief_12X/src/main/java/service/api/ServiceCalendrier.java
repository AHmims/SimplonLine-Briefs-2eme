package service.api;

import model.Administrateur;
import model.Calendrier;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ServiceCalendrier {
    int insert(Map<String, String> requestParams, Administrateur administrateur);
    boolean exists(Date date);
    List<String[]> getDates();
    Calendrier getByDate(Date date);
}
