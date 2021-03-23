package service.api;

import model.Apprenant;
import model.Authentification;

import java.util.List;

public interface ServiceApprenant {
    Apprenant getByAuthentication(Authentification authentification);
    List<Apprenant> getAll(boolean status);
}
