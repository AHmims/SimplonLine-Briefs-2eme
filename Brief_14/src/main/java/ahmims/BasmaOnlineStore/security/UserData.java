package ahmims.BasmaOnlineStore.security;

import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.service.UtilisateurService;
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
