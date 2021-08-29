package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Carte;
import ahmims.scuffed_BAKURA.model.Favori;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import ahmims.scuffed_BAKURA.repository.CarteRepository;
import ahmims.scuffed_BAKURA.repository.FavoriRepository;
import ahmims.scuffed_BAKURA.repository.UtilisateurRepository;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.FavoriService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("FavoriService")
public class FavoriServiceImpl implements FavoriService {
    private final FavoriRepository favoriRepository;
    private final JwtManager jwtManager;
    private final UtilisateurRepository utilisateurRepository;
    private final CarteRepository carteRepository;

    public FavoriServiceImpl(FavoriRepository favoriRepository, JwtManager jwtManager, UtilisateurRepository utilisateurRepository, CarteRepository carteRepository) {
        this.favoriRepository = favoriRepository;
        this.jwtManager = jwtManager;
        this.utilisateurRepository = utilisateurRepository;
        this.carteRepository = carteRepository;
    }

    @Override
    public boolean likeCard(boolean status, String cardId, String token) {
        try {
            if (token == null || token.length() == 0) {
                throw new RequestException("Invalid token", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String userEmail = jwtManager.getEmail(token.substring(7));
            Utilisateur utilisateur = utilisateurRepository.findTopByEmailUtilisateur(userEmail);

            Favori favori = this.favoriRepository.findTopByUtilisateur(utilisateur);
            if (favori == null) {
                favori = this.favoriRepository.save(new Favori(utilisateur));
            }

            Carte card = this.carteRepository.findTopByIdCarte(cardId);
            if (card == null) {
                throw new RequestException("Card id is invalid", HttpStatus.BAD_REQUEST);
            }

            Favori favoriSearchResult = this.favoriRepository.findTopByCartes_idCarte(cardId);

            if (status && favoriSearchResult == null) {
                favori.addCarte(card);
                this.favoriRepository.save(favori);
            } else if (!status && favoriSearchResult != null) {
                favori.removeCarte(card);
                this.favoriRepository.save(favori);
            }

            return true;
        } catch (Exception e) {
            throw new RequestException("Error while adding/removing card as a favorite", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Favori getUserFavorites(String token) {
        try {
            if (token == null || token.length() == 0) {
                throw new RequestException("Invalid token", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String userEmail = jwtManager.getEmail(token.substring(7));
            Utilisateur utilisateur = utilisateurRepository.findTopByEmailUtilisateur(userEmail);

            return this.favoriRepository.findTopByUtilisateur(utilisateur);
        } catch (Exception e) {
            throw new RequestException("Error while getting list of favorites", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
