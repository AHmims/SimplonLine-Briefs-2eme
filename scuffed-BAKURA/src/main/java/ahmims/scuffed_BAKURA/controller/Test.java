package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.model.Member;
import ahmims.scuffed_BAKURA.model.Role;
import ahmims.scuffed_BAKURA.repository.RoleRepository;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class Test {

    private final MemberService MemberService;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public Test(MemberService MemberService, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtManager jwtManager, ModelMapper modelMapper) {
        this.MemberService = MemberService;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/test")
    public String test() {
        Role role = new Role("hmmm", -99);
        role = roleRepository.save(role);
        Member member = new Member("XX", "XX", "XXX", new Date(), new Image());
        member.setRole(role);
        member = MemberService.save(member);
        return member.getIdUtilisateur();
        //return "good";
    }

    @GetMapping("/")
    public String testGet() {
        return "good";
    }

    @PostMapping("/api/test")
    public ResponseEntity<?> test2() { //<?> => is a wildcard meaning it can be any type
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
            roleRepository.save(role);
        }
        //
        return new ResponseEntity<>("ff", HttpStatus.valueOf(200));
    }
}
