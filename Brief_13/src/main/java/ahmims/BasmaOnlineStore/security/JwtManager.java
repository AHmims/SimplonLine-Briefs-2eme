package ahmims.BasmaOnlineStore.security;

import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtManager {
    @Value("${security.jwt.token.secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length}")
    private long validityInMilliseconds;

    @PostConstruct
    protected void onLoad() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Utilisateur utilisateur) {
        Claims claims = Jwts.claims().setSubject(utilisateur.getEmailUtilisateur());
        claims.put("auth", utilisateur.getRole().getNivRole());

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity).signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }
}
