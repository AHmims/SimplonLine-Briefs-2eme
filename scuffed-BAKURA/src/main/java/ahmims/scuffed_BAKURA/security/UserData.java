package ahmims.scuffed_BAKURA.security;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import ahmims.scuffed_BAKURA.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserData implements UserDetailsService {
    UtilisateurService utilisateurService;

    public UserData(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Utilisateur user = utilisateurService.findTopByEmail(s);
        if (user == null)
            throw new RequestException("Please re-login", HttpStatus.NOT_FOUND);
        return User.withUsername(user.getEmailUtilisateur()).password(user.getPassUtilisateur()).authorities(user.getRole().getNivRole() + "").build();
    }
}
