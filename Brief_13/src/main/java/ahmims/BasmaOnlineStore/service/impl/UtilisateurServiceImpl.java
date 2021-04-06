package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dto.RoleShort;
import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Administrateur;
import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.AdministrateurService;
import ahmims.BasmaOnlineStore.service.ClientService;
import ahmims.BasmaOnlineStore.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {
    private final ClientService clientService;
    private final AdministrateurService administrateurService;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public UtilisateurServiceImpl(ClientService clientService, AdministrateurService administrateurService, JwtManager jwtManager, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.administrateurService = administrateurService;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseData loginUser(UserAuthInputData userAuthInputData) {
        if (userAuthInputData.getEmail() != null && userAuthInputData.getPassword() != null) {
            Client client = clientService.getByEmail(userAuthInputData.getEmail());
            if (client != null) {
                if (client.getPassUtilisateur().equals(userAuthInputData.getPassword()))
                    return setupLoginResponse(client);
            } else {
                Administrateur administrateur = administrateurService.getByEmail(userAuthInputData.getEmail());
                if (administrateur != null) {
                    if (administrateur.getPassUtilisateur().equals(userAuthInputData.getPassword()))
                        return setupLoginResponse(administrateur);
                } else throw new RequestException("Il existe aucun compte avec cet email", HttpStatus.NOT_FOUND);
            }
            throw new RequestException("Le mot de passe est incorrect.", HttpStatus.UNAUTHORIZED);
        } else
            throw new RequestException("Le format des données n'est pas valide. Vous devez fournir \"email\" et \"password\"", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    //
    //
    private UserResponseData setupLoginResponse(Utilisateur utilisateur) {
        UserResponseData userResponseData = modelMapper.map(utilisateur, UserResponseData.class);
        userResponseData.setRole(modelMapper.map(utilisateur.getRole(), RoleShort.class));
        userResponseData.setToken(jwtManager.createToken(utilisateur));
        return userResponseData;
    }
}
