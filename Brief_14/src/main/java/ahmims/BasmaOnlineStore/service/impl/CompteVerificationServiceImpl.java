package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CompteVerificationDao;
import ahmims.BasmaOnlineStore.dao.UtilisateurDao;
import ahmims.BasmaOnlineStore.dto.EmailFormat;
import ahmims.BasmaOnlineStore.dto.RoleShort;
import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.CompteVerification;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.CompteVerificationService;
import ahmims.BasmaOnlineStore.util.EmailSender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("CompteVerificationService")
public class CompteVerificationServiceImpl implements CompteVerificationService {
    //#region
    private final CompteVerificationDao compteVerificationDao;
    private final UtilisateurDao utilisateurDao;
    private final EmailSender emailSender;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;


    public CompteVerificationServiceImpl(CompteVerificationDao compteVerificationDao, EmailSender emailSender, JwtManager jwtManager, ModelMapper modelMapper, UtilisateurDao utilisateurDao) {
        this.compteVerificationDao = compteVerificationDao;
        this.emailSender = emailSender;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
        this.utilisateurDao = utilisateurDao;
    }

    //#endregion
    //
    @Override
    public boolean sendEmail(Utilisateur utilisateur) {
        if (utilisateur != null && utilisateur.getIdUtilisateur().length() > 0) {
            CompteVerification compteVerification = compteVerificationDao.save(new CompteVerification(utilisateur));
            if (compteVerification.getIdCompteVerification() != null) {
                EmailFormat emailFormat = new EmailFormat();
                emailFormat.setReceiver(utilisateur.getEmailUtilisateur());
                emailFormat.setSubject("BasmaOnlineStore account verification");
                String verificationLink = String.format("http://localhost:3420/valider/%s", compteVerification.getIdCompteVerification());
                emailFormat.setContent(String.format("Bonjour %s %s.\n</br>Pour valider votre compte, veuillez ouvrir le lien suivant:\n<a href=\"%s\"><h3>Lien de verification</h3></a>", utilisateur.getNomUtilisateur(), utilisateur.getPrenomUtilisateur(), verificationLink));
                //
                //
                return emailSender.sendEmail(emailFormat);
            } else throw new RequestException("CompteVerification not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        } else throw new RequestException("Utilisateur invalid", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public UserResponseData validate(String idCompteVerification) {
        if (idCompteVerification != null && idCompteVerification.length() > 0) {
            Optional<CompteVerification> optionalCompteVerification = compteVerificationDao.findById(idCompteVerification);
            if (optionalCompteVerification.isPresent()) {
                CompteVerification compteVerification = optionalCompteVerification.get();
                if (compteVerification.getStatutCompteVerification() == 0) {
                    compteVerification.setStatutCompteVerification(1);
                    //
                    Utilisateur utilisateur = compteVerification.getUtilisateur();
                    utilisateur.setStatutUtilisateur(1);
                    compteVerification.setUtilisateur(utilisateur);
                    //
                    compteVerificationDao.save(compteVerification);
                    //
                    return setupLoginResponse(utilisateur);
                } else throw new RequestException("Compte already validated", HttpStatus.ALREADY_REPORTED);
            }
        }
        throw new RequestException("Url invalide", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    //
    //
    private UserResponseData setupLoginResponse(Utilisateur utilisateur) {
        UserResponseData userResponseData = modelMapper.map(utilisateur, UserResponseData.class);
        userResponseData.setRole(utilisateur.getRole() != null ? modelMapper.map(utilisateur.getRole(), RoleShort.class) : null);
        userResponseData.setToken(jwtManager.createToken(utilisateur));
        return userResponseData;
    }
}
