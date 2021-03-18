package service.api;

import model.Administrateur;

public interface ServiceAdministrateur {
    Administrateur getByEmail(String email);
}
