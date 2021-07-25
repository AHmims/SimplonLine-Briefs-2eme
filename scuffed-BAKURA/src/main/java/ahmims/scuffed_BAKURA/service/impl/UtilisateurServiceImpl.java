package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dto.*;
import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.*;
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
import java.util.List;
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
    private final ImageService imageService;

    public UtilisateurServiceImpl(MemberService MemberService, AdministrateurService administrateurService, JwtManager jwtManager, ModelMapper modelMapper, UtilisateurValidator utilisateurValidator, RoleService roleService, UtilisateurRepository utilisateurRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, CompteVerificationService compteVerificationService, ImageService imageService) {
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
        this.imageService = imageService;
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
            Utilisateur user;
            user = userFormData.getType().equalsIgnoreCase("member") ? new Member(userFormData) : userFormData.getType().equalsIgnoreCase("administrateur") ? new Administrateur(userFormData) : null;
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
                    if (!userFormData.getType().equalsIgnoreCase("member")) {
                        libelleRole = "Role_2";
                    }
                    Role role = roleService.getByLibelle(libelleRole);
                    if (role == null)
                        throw new RequestException("Server error. Role not found", HttpStatus.BAD_REQUEST);
                    //
                    Image userImage = imageService.assertImage(userFormData.getAvatar());
                    //if(role.getNivRole() > 0)
                    //test if current logged user is allowed to create an account for someone other than Members
                    user.setRole(role);
                    user.setAvatarUtilisateur(userImage);
                    user.setPassUtilisateur(passwordEncoder.encode(user.getPassUtilisateur()));
                    if (user.getClass() == Administrateur.class) {
                        user.setStatutUtilisateur(1);
                    }
                    user = insertUser(user);
                    if (user != null && user.getIdUtilisateur() != null) {
                        //all good
                        if (user.getClass().equals(Member.class)) {
                            if (!compteVerificationService.sendEmail(user)) {
                                deleteUser(user.getIdUtilisateur());
                                throw new RequestException("Verification email not sent", HttpStatus.INTERNAL_SERVER_ERROR);
                            }
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

    @Override
    public List<UserMainData> getAll() {
        List<Utilisateur> users = utilisateurRepository.findAll();
        if (users.size() == 0)
            return new ArrayList<>();

        List<UserMainData> usersMainData = new ArrayList<>();
        for (Utilisateur user : users) {
            usersMainData.add(getUerResponse(user));
        }

        return usersMainData;
    }

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
            Image userImage = imageService.assertImage(utilisateur.getAvatar());
            if (userImage != null) {
                originalUser.setAvatarUtilisateur(userImage);
            }

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
            return getUerResponse(originalUser);
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public DeleteRes deleteUser(String id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            Utilisateur utilisateur = user.get();
            utilisateurRepository.deleteById(id);

            user = utilisateurRepository.findById(id);
            //
            return new DeleteRes(user.isEmpty() ? 1 : 0, utilisateur.getIdUtilisateur(), utilisateur.getClass().getSimpleName());
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public UserMainData get(String id) {
        Optional<Utilisateur> user = utilisateurRepository.findById(id);
        if (user.isPresent()) {
            return getUerResponse(user.get());
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public UserMainData getByToken(String token) {
        if (token != null && token.length() > 0) {
            String userEmail = jwtManager.getEmail(token.substring(7));
            Utilisateur utilisateur = utilisateurRepository.findTopByEmailUtilisateur(userEmail);
            if (utilisateur != null) {
                return getUerResponse(utilisateur);
            }
        }

        return null;
    }

    @Override
    public UserMainData updateUserByToken(UserFormData utilisateur, String token) {
        if (token != null && token.length() > 0) {
            String userEmail = jwtManager.getEmail(token.substring(7));
            Utilisateur utilisateurObject = utilisateurRepository.findTopByEmailUtilisateur(userEmail);
            if (utilisateur != null) {
                return updateUser(utilisateur, utilisateurObject.getIdUtilisateur());
            }
        }

        return null;
    }

    @Override
    public UpdateRes controllAccount(String idUtilisateur, int status) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(idUtilisateur);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            if (status != utilisateur.getStatutUtilisateur()) {
                utilisateur.setStatutUtilisateur(status);
                utilisateur = utilisateurRepository.save(utilisateur);
                //
                if (utilisateur.getStatutUtilisateur() == status)
                    return new UpdateRes(true, utilisateur.getIdUtilisateur(), utilisateur.getClass().getSimpleName());
                else throw new RequestException("Account was not performed", HttpStatus.BAD_REQUEST);
            } else {
                String message = "Account already ";
                switch (status) {
                    case -1:
                        message = message.concat("disabled");
                        break;
                    case 0:
                        message = message.concat("inactive");
                        break;
                    case 1:
                        message = message.concat("active");
                        break;
                    default:
                        message = "Unknown action";
                }

                throw new RequestException(message, HttpStatus.BAD_REQUEST);
            }
        } else throw new RequestException("User not found", HttpStatus.NOT_FOUND);
    }


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
            mapper.map(Utilisateur::getAvatarUtilisateur, UserMainData::setAvatar);
        });
        //
        UserMainData userMainData = modelMapper.map(utilisateur, UserMainData.class);
        userMainData.setRole(utilisateur.getRole() != null ? modelMapper.map(utilisateur.getRole(), RoleShort.class) : null);
        userMainData.setTypeUtilisateurByClass(utilisateur.getClass());
        userMainData.setStatus(utilisateur.getStatutUtilisateur());
        //
        return userMainData;
    }
}
