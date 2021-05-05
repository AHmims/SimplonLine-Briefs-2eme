package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CommandeDao;
import ahmims.BasmaOnlineStore.dao.UtilisateurDao;
import ahmims.BasmaOnlineStore.dto.CommandeMin;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Commande;
import ahmims.BasmaOnlineStore.model.Panier;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.repository.CommandeRepository;
import ahmims.BasmaOnlineStore.repository.PanierRepository;
import ahmims.BasmaOnlineStore.service.CommandeService;
import ahmims.BasmaOnlineStore.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("CommandeService")
public class CommandeServiceImpl implements CommandeService {
    private final CommandeDao commandeDao;
    private final CommandeRepository commandeRepository;
    private final PanierRepository panierRepository;
    private final UtilisateurDao utilisateurDao;

    public CommandeServiceImpl(CommandeDao commandeDao, CommandeRepository commandeRepository, PanierRepository panierRepository,UtilisateurDao utilisateurDao) {
        this.commandeDao = commandeDao;
        this.commandeRepository = commandeRepository;
        this.panierRepository = panierRepository;
        this.utilisateurDao = utilisateurDao;
    }

    //
    //
    @Override
    public List<CommandeMin> getByUser(String idUser) {
        Optional<Utilisateur> user = utilisateurDao.findById(idUser);
        if (user.isEmpty())
            throw new RequestException("User id not found", HttpStatus.NOT_FOUND);
        //
        List<Panier> paniers = panierRepository.findAllByClient(user.get());
        if(paniers==null)
            throw new RequestException("Error getting list of carts for selected user",HttpStatus.BAD_REQUEST);
        //
        List<Commande> commandes = new ArrayList<>();
        for (Panier panier:paniers) {
            commandes.add(commandeRepository.findTopByPanier(panier));
        }
        //
        List<CommandeMin> commandeMins = new ArrayList<>();
        for (Commande commande:commandes) {
            commandeMins.add(new CommandeMin(commande));
        }
        //
        return commandeMins;
    }
}
