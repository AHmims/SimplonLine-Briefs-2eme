package service.api;

import model.Apprenant;
import model.Authentification;

public interface ServiceApprenant {
    Apprenant getByAuthentication(Authentification authentification);
}
