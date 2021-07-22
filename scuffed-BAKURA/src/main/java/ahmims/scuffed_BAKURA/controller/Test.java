/* package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dao.RoleDao;
import ahmims.scuffed_BAKURA.dto.UserAuthInputData;
import ahmims.scuffed_BAKURA.model.Member;
import ahmims.scuffed_BAKURA.model.Role;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class Test {

    private final MemberService MemberService;
    private final RoleDao roleDao;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public Test(MemberService MemberService, RoleDao roleDao, AuthenticationManager authenticationManager, JwtManager jwtManager, ModelMapper modelMapper) {
        this.MemberService = MemberService;
        this.roleDao = roleDao;
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/test")
    public String test() {
        Role role = new Role("hmmm", -99);
        role = roleDao.save(role);
        Member member = new Member("XX", "XX", "XXX", "XX", new Date(), "");
        member.setRole(role);
        member = MemberService.save(member);
        return member.getIdUtilisateur();
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
**/
