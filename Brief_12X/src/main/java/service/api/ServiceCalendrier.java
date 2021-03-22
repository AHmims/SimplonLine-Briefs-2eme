package service.api;

import model.Administrateur;

import java.util.Date;
import java.util.Map;

public interface ServiceCalendrier {
    int insert(Map<String, String> requestParams, Administrateur administrateur);
    boolean exists(Date date);
}
