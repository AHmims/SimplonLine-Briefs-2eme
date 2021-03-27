package service.api;

import model.Calendrier;
import model.Jour;

public interface ServiceJour {
    Jour get(int nbJour, Calendrier calendrier);
}
