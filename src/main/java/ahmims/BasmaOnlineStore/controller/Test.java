package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dao.*;
import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.*;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class Test {

    private final ClientService clientService;
    private final RoleDao roleDao;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;
    @Autowired
    ProduitDao produitDao;
    @Autowired
    PanierDao panierDao;
    @Autowired
    CommandeDao commandeDao;
    @Autowired
    AdresseDao adresseDao;

    public Test(ClientService clientService, RoleDao roleDao, AuthenticationManager authenticationManager, JwtManager jwtManager, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.roleDao = roleDao;
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/test")
    public String test() {
        Role role = new Role("hmmm", -99);
        role = roleDao.save(role);
        Client client = new Client("XX", "XX", "XXX", "XX", new Date(), "");
        client.setRole(role);
        client = clientService.save(client);
        return client.getIdUtilisateur();
        //return "good";
    }

    @GetMapping("/")
    public String testGet() {
        return "good";
    }

    @PostMapping("/test")
    public ResponseEntity<?> test2(@RequestBody UserAuthInputData payload) { //<?> => is a wildcard meaning it can be any type
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(payload.getEmailUtilisateur(), payload.getPassUtilisateur()));
        //String jwt = jwtManager.createToken(payload.getEmailUtilisateur(), new Role("__hmm", -99));
        //System.out.println(jwt);
        //System.out.println(payload.getEmailUtilisateur());
        //return modelMapper.map(new Role("test", 12), Role.class);
        //return new ResponseEntity<>(modelMapper.map(payload, UserAuthInputData.class), HttpStatus.valueOf(200));


        //creating new roles
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role("Role_1", 0));
        roles.add(new Role("Role_2", 1));
        roles.add(new Role("Role_3", 2));
        for (Role role : roles) {
            roleDao.save(role);
        }
        //
        return new ResponseEntity<>("ff", HttpStatus.valueOf(200));
    }

    //
    //
    @PostMapping("/cmd")
    public ResponseEntity<?> test3() {
        try {
            Client user = clientService.getByEmail("nioce147@gmail.com");
            Adresse adresse = adresseDao.save(new Adresse("bad", "end", "is", "a", 420, "good", "end"));
            Iterable<Produit> produits = produitDao.findAll();
            Panier panier = new Panier();
            panier.setClient(user);
            List<ProduitPanier> produitPaniers = new ArrayList<>();
            produits.forEach(produit -> {
                produitPaniers.add(new ProduitPanier(1, produit, panier));
            });
            panier.setProduits(produitPaniers);
            Commande commande = commandeDao.save(new Commande(new Date(), 0, adresse, panier));
            return new ResponseEntity<>(commande, HttpStatus.OK);
        } catch (Exception e) {
            throw new RequestException("bad", HttpStatus.BAD_REQUEST);
        }
    }
}
