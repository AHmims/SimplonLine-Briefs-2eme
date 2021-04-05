package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.model.Role;
import ahmims.BasmaOnlineStore.security.JwtTokenProvider;
import ahmims.BasmaOnlineStore.service.ClientService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class Test {

    private final ClientService clientService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public Test(ClientService clientService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.clientService = clientService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/user")
    public String loginSuccess() {
        Client client = new Client("XX", "XX", "XX", "XX", new Date(), "");
        client = clientService.save(client);
        return client.getIdUtilisateur();
        //return "good";
    }

    @PostMapping("/auth/signin")
    public String login(@ApiParam("email") @RequestParam String email, @ApiParam("pass") @RequestParam String pass) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, pass));
        return jwtTokenProvider.createToken(email, new Role("__hmm", -99));
    }
}
