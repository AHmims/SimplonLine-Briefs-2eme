package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dao.RoleDao;
import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.model.Role;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class Test {

    private final ClientService clientService;
    private final RoleDao roleDao;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

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
}
