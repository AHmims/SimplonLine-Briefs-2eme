package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dto.EmailFormat;
import ahmims.scuffed_BAKURA.dto.RoleShort;
import ahmims.scuffed_BAKURA.dto.UserResponseData;
import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.CompteVerification;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import ahmims.scuffed_BAKURA.repository.CompteVerificationRepository;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.CompteVerificationService;
import ahmims.scuffed_BAKURA.util.EmailSender;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("CompteVerificationService")
public class CompteVerificationServiceImpl implements CompteVerificationService {
    private final EmailSender emailSender;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;
    private final CompteVerificationRepository compteVerificationRepository;
    //#region
    @Value("${server-url}")
    private String serverUrl;


    public CompteVerificationServiceImpl(EmailSender emailSender, JwtManager jwtManager, ModelMapper modelMapper, CompteVerificationRepository compteVerificationRepository) {
        this.emailSender = emailSender;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
        this.compteVerificationRepository = compteVerificationRepository;
    }

    //#endregion
    //
    @Override
    public boolean sendEmail(Utilisateur utilisateur) {
        if (utilisateur != null && utilisateur.getIdUtilisateur().length() > 0) {
            CompteVerification compteVerification = compteVerificationRepository.save(new CompteVerification(utilisateur));
            if (compteVerification.getIdCompteVerification() != null) {
                EmailFormat emailFormat = new EmailFormat();
                emailFormat.setReceiver(utilisateur.getEmailUtilisateur());
                emailFormat.setSubject("scuffed_BAKURA account verification");
                String verificationLink = String.format("%s/valider/%s", serverUrl, compteVerification.getIdCompteVerification());
                emailFormat.setContent(String.format("Bonjour %s.\n</br>Pour valider votre compte, veuillez ouvrir le lien suivant:\n<a href=\"%s\"><h3>Lien de verification</h3></a>", utilisateur.getNomUtilisateur(), verificationLink));
                //
                //
                return emailSender.sendEmail(emailFormat);
            } else throw new RequestException("CompteVerification not saved", HttpStatus.INTERNAL_SERVER_ERROR);
        } else throw new RequestException("Utilisateur invalid", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public UserResponseData validate(String idCompteVerification) {
        if (idCompteVerification != null && idCompteVerification.length() > 0) {
            Optional<CompteVerification> optionalCompteVerification = compteVerificationRepository.findById(idCompteVerification);
            if (optionalCompteVerification.isPresent()) {
                CompteVerification compteVerification = optionalCompteVerification.get();
                if (compteVerification.getStatutCompteVerification() == 0) {
                    compteVerification.setStatutCompteVerification(1);
                    //
                    Utilisateur utilisateur = compteVerification.getUtilisateur();
                    utilisateur.setStatutUtilisateur(1);
                    compteVerification.setUtilisateur(utilisateur);
                    //
                    compteVerificationRepository.save(compteVerification);
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
