package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.UtilisateurDao;
import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.*;
import ahmims.BasmaOnlineStore.repository.UtilisateurRepository;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.*;
import ahmims.BasmaOnlineStore.validator.UtilisateurValidator;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {
    //#region
    private final ClientService clientService;
    private final AdministrateurService administrateurService;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;
    private final UtilisateurValidator utilisateurValidator;
    private final RoleService roleService;
    private final GerantEntrepotService gerantEntrepotService;
    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurDao utilisateurDao;

    public UtilisateurServiceImpl(ClientService clientService, AdministrateurService administrateurService, JwtManager jwtManager, ModelMapper modelMapper, UtilisateurValidator utilisateurValidator, RoleService roleService, GerantEntrepotService gerantEntrepotService, UtilisateurRepository utilisateurRepository, UtilisateurDao utilisateurDao) {
        this.clientService = clientService;
        this.administrateurService = administrateurService;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
        this.utilisateurValidator = utilisateurValidator;
        this.roleService = roleService;
        this.gerantEntrepotService = gerantEntrepotService;
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurDao = utilisateurDao;
    }

    //#endregion
    @Override
    public UserResponseData loginUser(UserAuthInputData userAuthInputData) {
        if (userAuthInputData.isFilled()) {
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

    @Override
    public UserResponseData createUser(UserFormData userFormData) {
        if (userFormData.isFilled(0)) {
            Utilisateur user = null;
            user = userFormData.getType().toLowerCase().equals("client") ? new Client(userFormData, null) : userFormData.getType().toLowerCase().equals("administrateur") ? new Administrateur(userFormData) : userFormData.getType().toLowerCase().equals("gerantentrepot") ? new GerantEntrepot(userFormData) : null;
            //
            ArrayList<Validation> validations = utilisateurValidator.isValidNewObject(user);
            if (validations != null) {
                StringBuilder errorMessage = new StringBuilder();
                boolean isValid = true;
                for (Validation validation : validations) {
                    if (!validation.isResult()) {
                        isValid = false;
                        if (!errorMessage.toString().equals(""))
                            errorMessage.append(" | ");
                        errorMessage.append(String.format("%s", validation.getMessage()));
                    }
                }
                if (!isValid) throw new RequestException(errorMessage.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
                else {
                    String libelleRole = "Role_1";
                    if (!userFormData.getType().toLowerCase().equals("client"))
                        libelleRole = "Role_2";
                    Role role = roleService.getByLibelle(libelleRole);
                    if (role == null)
                        throw new RequestException("Server error. Role not found", HttpStatus.BAD_REQUEST);
                    //
                    //if(role.getNivRole() > 0)
                    //test if current logged user is allowed to create an account for someone other than clients
                    user.setRole(role);
                    user = insertUser(user);
                    if (user != null && user.getIdUtilisateur() != null)
                        //all good
                        return setupLoginResponse(user);
                    else
                        throw new RequestException("Server error. User not saved", HttpStatus.BAD_REQUEST);
                }
            } else throw new RequestException("Le champ <type> est invalide", HttpStatus.BAD_REQUEST);
        } else
            throw new RequestException("Le format des données n'est pas valide. Vous devez fournir \"nom\"|\"prenom\"|\"email\"|\"password\"|\"type\"", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public Utilisateur insertUser(Utilisateur utilisateur) {
        switch (utilisateur.getClass().getSimpleName()) {
            case "Client":
                return clientService.save((Client) utilisateur);
            case "Administrateur":
                return administrateurService.save((Administrateur) utilisateur);
            case "GerantEntrepot":
                return gerantEntrepotService.save((GerantEntrepot) utilisateur);
            default:
                throw new RequestException("Server breakdown, unknown User", HttpStatus.BAD_REQUEST);
                //break;
        }
    }

    @Override
    public Utilisateur findTopByEmail(String email) {
        return utilisateurRepository.findTopByEmailUtilisateur(email);
    }

    @Override
    public AllUsers getAll() {
        List<Utilisateur> users = (List<Utilisateur>) utilisateurDao.findAll();
        if (users.size() == 0)
            return new AllUsers(new ArrayList<>());
        List<UserMainData> usersMainData = new ArrayList<>();
        //
        modelMapper.typeMap(Utilisateur.class, UserMainData.class).addMappings(mapper -> {
            mapper.map(Utilisateur::getNomUtilisateur, UserMainData::setNom);
            mapper.map(Utilisateur::getPrenomUtilisateur, UserMainData::setPrenom);
            mapper.map(Utilisateur::getEmailUtilisateur, UserMainData::setEmail);
            mapper.map(Utilisateur::getIdUtilisateur, UserMainData::setId);
        });
        //
        for (Utilisateur user : users) {
            UserMainData userMainData = modelMapper.map(user, UserMainData.class);
            userMainData.setRole(user.getRole() != null ? modelMapper.map(user.getRole(), RoleShort.class) : null);
            if (user.getClass().getSimpleName().equals(Client.class.getSimpleName()))
                userMainData.setImage(((Client) user).getImgClient());
            userMainData.setTypeUtilisateurByClass(user.getClass());
            usersMainData.add(userMainData);
        }
        //
        return new AllUsers(usersMainData);
    }

    @Override
    public UserMainData updateUser(UserFormData utilisateur, String id) {
        Optional<Utilisateur> user = utilisateurDao.findById(id);
        if (user.isPresent()) {
            Utilisateur originalUser = user.get();
            //
            if (utilisateur.getNom() != null)
                originalUser.setNomUtilisateur(utilisateur.getNom());
            if (utilisateur.getPrenom() != null)
                originalUser.setPrenomUtilisateur(utilisateur.getPrenom());
            if (utilisateur.getEmail() != null)
                originalUser.setEmailUtilisateur(utilisateur.getEmail());
            if (utilisateur.getPassword() != null)
                originalUser.setPassUtilisateur(utilisateur.getPassword());
            if (originalUser.getClass().getSimpleName().equals(Client.class.getSimpleName()) && utilisateur.getImg() != null)
                ((Client) originalUser).setImgClient(utilisateur.getImg());
            //
            ArrayList<Validation> validations = utilisateurValidator.isValidNewObject(originalUser);
            StringBuilder errorMessage = new StringBuilder();
            boolean isValid = true;
            for (Validation validation : validations) {
                if (!validation.isResult()) {
                    isValid = false;
                    if (!errorMessage.toString().equals(""))
                        errorMessage.append(" | ");
                    errorMessage.append(String.format("%s", validation.getMessage()));
                }
            }
            if (!isValid) throw new RequestException(errorMessage.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
            //
            originalUser = utilisateurDao.save(originalUser);
            if (originalUser != null) {
                modelMapper.typeMap(Utilisateur.class, UserMainData.class).addMappings(mapper -> {
                    mapper.map(Utilisateur::getNomUtilisateur, UserMainData::setNom);
                    mapper.map(Utilisateur::getPrenomUtilisateur, UserMainData::setPrenom);
                    mapper.map(Utilisateur::getEmailUtilisateur, UserMainData::setEmail);
                    mapper.map(Utilisateur::getIdUtilisateur, UserMainData::setId);
                });
                UserMainData userMainData = modelMapper.map(originalUser, UserMainData.class);
                userMainData.setRole(originalUser.getRole() != null ? modelMapper.map(originalUser.getRole(), RoleShort.class) : null);
                if (originalUser.getClass().getSimpleName().equals(Client.class.getSimpleName()))
                    userMainData.setImage(((Client) originalUser).getImgClient());
                userMainData.setTypeUtilisateurByClass(originalUser.getClass());
                //
                return userMainData;
            } else throw new RequestException("User not updated", HttpStatus.INTERNAL_SERVER_ERROR);
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
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
