package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dto.*;
import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Administrateur;
import ahmims.scuffed_BAKURA.model.Member;
import ahmims.scuffed_BAKURA.model.Role;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import ahmims.scuffed_BAKURA.repository.UtilisateurRepository;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.*;
import ahmims.scuffed_BAKURA.validator.UtilisateurValidator;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service("UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {
    //#region
    private final MemberService MemberService;
    private final AdministrateurService administrateurService;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;
    private final UtilisateurValidator utilisateurValidator;
    private final RoleService roleService;
    private final UtilisateurRepository utilisateurRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final CompteVerificationService compteVerificationService;

    public UtilisateurServiceImpl(MemberService MemberService, AdministrateurService administrateurService, JwtManager jwtManager, ModelMapper modelMapper, UtilisateurValidator utilisateurValidator, RoleService roleService, UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, CompteVerificationService compteVerificationService) {
        this.MemberService = MemberService;
        this.administrateurService = administrateurService;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
        this.utilisateurValidator = utilisateurValidator;
        this.roleService = roleService;
        this.utilisateurRepository = utilisateurRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.compteVerificationService = compteVerificationService;
    }

    //#endregion
    @Override
    public UserResponseData loginUser(UserFormData userAuthInputData) {
        if (userAuthInputData.isFilled(2)) {
            try {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthInputData.getEmail(), userAuthInputData.getPassword()));
                Utilisateur utilisateur = utilisateurRepository.findTopByEmailUtilisateur(userAuthInputData.getEmail());
                if (utilisateur.getClass().equals(Member.class)) {
                    switch (utilisateur.getStatutUtilisateur()) {
                        case -1:
                            throw new RequestException("Your account has been disabled, please contact us if you believe this is a mistake.", HttpStatus.BAD_REQUEST);
                        case 0:
                            throw new RequestException("Please validate your account first before accessing the platform", HttpStatus.BAD_REQUEST);
                        default:
                            break;
                    }
                }
                return setupLoginResponse(findTopByEmail(userAuthInputData.getEmail()));
            } catch (AuthenticationException e) {
                throw new RequestException("Email/mot de passe fourni non valide", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } else
            throw new RequestException("Le format des données n'est pas valide. Vous devez fournir \"email\" et \"password\"", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public UserResponseData createUser(UserFormData userFormData) {
        if (userFormData.isFilled(0)) {
            if (utilisateurRepository.findTopByEmailUtilisateur(userFormData.getEmail()) != null)
                throw new RequestException("Email already exists, choose another one", HttpStatus.BAD_REQUEST);
            Utilisateur user = null;
            user = userFormData.getType().toLowerCase().equals("member") ? new Member(userFormData, null) : userFormData.getType().toLowerCase().equals("administrateur") ? new Administrateur(userFormData) : null;
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
                    if (!userFormData.getType().toLowerCase().equals("member")) {
                        libelleRole = "Role_2";
                    }
                    Role role = roleService.getByLibelle(libelleRole);
                    if (role == null)
                        throw new RequestException("Server error. Role not found", HttpStatus.BAD_REQUEST);
                    //
                    //if(role.getNivRole() > 0)
                    //test if current logged user is allowed to create an account for someone other than Members
                    user.setRole(role);
                    user.setPassUtilisateur(passwordEncoder.encode(user.getPassUtilisateur()));
                    user = insertUser(user);
                    if (user != null && user.getIdUtilisateur() != null) {
                        //all good
                        if (user.getClass().equals(Member.class)) {
                            if (!compteVerificationService.sendEmail(user)) {
                                deleteUser(user.getIdUtilisateur());
                                throw new RequestException("Verification email not sent", HttpStatus.INTERNAL_SERVER_ERROR);
                            }
                        } else {
                            user.setStatutUtilisateur(1);
                        }
                        return setupLoginResponse(user);
                    } else throw new RequestException("Server error. User not saved", HttpStatus.BAD_REQUEST);
                }
            } else throw new RequestException("Le champ <type> est invalide", HttpStatus.BAD_REQUEST);
        } else
            throw new RequestException("Le format des données n'est pas valide. Vous devez fournir \"nom\"|\"prenom\"|\"email\"|\"password\"|\"type\"", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public Utilisateur insertUser(Utilisateur utilisateur) {
        switch (utilisateur.getClass().getSimpleName()) {
            case "Member":
                return MemberService.save((Member) utilisateur);
            case "Administrateur":
                return administrateurService.save((Administrateur) utilisateur);
            default:
                throw new RequestException("Server breakdown, unknown User", HttpStatus.BAD_REQUEST);
                //break;
        }
    }

    @Override
    public Utilisateur findTopByEmail(String email) {
        return utilisateurRepository.findTopByEmailUtilisateur(email);
    }

    /*@Override
    public AllUsers getAll() {
        List<Utilisateur> users = (List<Utilisateur>) utilisateurDao.findAll();
        if (users.size() == 0)
            return new AllUsers(new ArrayList<>());
        List<UserMainData> usersMainData = new ArrayList<>();

        //
        for (Utilisateur user : users) {
            usersMainData.add(getUerResponse(user));
        }
        //
        return new AllUsers(usersMainData);
    }*/

    @Override
    public UserMainData updateUser(UserFormData utilisateur, String id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            Utilisateur originalUser = user.get();
            //
            if (utilisateur.getNom() != null)
                originalUser.setNomUtilisateur(utilisateur.getNom());
            if (utilisateur.getEmail() != null)
                originalUser.setEmailUtilisateur(utilisateur.getEmail());
            if (utilisateur.getPassword() != null) {
                if (!passwordEncoder.matches(utilisateur.getPassword(), originalUser.getPassUtilisateur()))
                    originalUser.setPassUtilisateur(passwordEncoder.encode(utilisateur.getPassword()));
            }
            if (originalUser.getClass().getSimpleName().equals(Member.class.getSimpleName()) && utilisateur.getImg() != null)
                ((Member) originalUser).setImgMember(utilisateur.getImg());
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
            originalUser = utilisateurRepository.save(originalUser);
            if (originalUser != null) {
                return getUerResponse(originalUser);
            } else throw new RequestException("User not updated", HttpStatus.INTERNAL_SERVER_ERROR);
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public DeleteRes deleteUser(String id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            Utilisateur utilisateur = user.get();
            utilisateurRepository.deleteById(id);
            //
            return new DeleteRes(-1, utilisateur.getIdUtilisateur(), utilisateur.getClass().getSimpleName());
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public UserMainData get(String id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            return getUerResponse(user.get());
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }

    /*@Override
    public UpdateRes disableAccount(String idUtilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurDao.findById(idUtilisateur);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            utilisateur.setStatutUtilisateur(-1);
            utilisateur = utilisateurDao.save(utilisateur);
            //
            if (utilisateur.getStatutUtilisateur() == -1)
                return new UpdateRes(true, utilisateur.getIdUtilisateur(), utilisateur.getClass().getSimpleName());
            else throw new RequestException("Account was not disabled", HttpStatus.BAD_REQUEST);
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }*/


    //
    //
    private UserResponseData setupLoginResponse(Utilisateur utilisateur) {
        UserResponseData userResponseData = modelMapper.map(utilisateur, UserResponseData.class);
        userResponseData.setRole(utilisateur.getRole() != null ? modelMapper.map(utilisateur.getRole(), RoleShort.class) : null);
        if (utilisateur.getStatutUtilisateur() == 1)
            userResponseData.setToken(jwtManager.createToken(utilisateur));
        return userResponseData;
    }

    private UserMainData getUerResponse(Utilisateur utilisateur) {
        modelMapper.typeMap(Utilisateur.class, UserMainData.class).addMappings(mapper -> {
            mapper.map(Utilisateur::getNomUtilisateur, UserMainData::setNom);
            mapper.map(Utilisateur::getEmailUtilisateur, UserMainData::setEmail);
            mapper.map(Utilisateur::getIdUtilisateur, UserMainData::setId);
        });
        //
        UserMainData userMainData = modelMapper.map(utilisateur, UserMainData.class);
        userMainData.setRole(utilisateur.getRole() != null ? modelMapper.map(utilisateur.getRole(), RoleShort.class) : null);
        if (utilisateur.getClass().getSimpleName().equals(Member.class.getSimpleName()))
            userMainData.setImage(((Member) utilisateur).getImgMember());
        userMainData.setTypeUtilisateurByClass(utilisateur.getClass());
        //
        return userMainData;
    }
}
