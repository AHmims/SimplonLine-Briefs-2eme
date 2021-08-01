package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.CardValues;
import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.model.Member;
import ahmims.scuffed_BAKURA.model.Role;
import ahmims.scuffed_BAKURA.repository.RoleRepository;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.AttributeService;
import ahmims.scuffed_BAKURA.service.MemberService;
import ahmims.scuffed_BAKURA.service.RaceService;
import ahmims.scuffed_BAKURA.util.Requester;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Test {

    private final MemberService MemberService;
    private final RoleRepository roleRepository;
    private final RaceService raceService;
    private final AttributeService attributeService;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public Test(MemberService MemberService, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtManager jwtManager, ModelMapper modelMapper, RaceService raceService, AttributeService attributeService) {
        this.MemberService = MemberService;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
        this.raceService = raceService;
        this.attributeService = attributeService;
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
    public ResponseEntity<?> test2() {
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

    @PostMapping("/api/seed")
    public ResponseEntity<?> seed() {
        ArrayList<String> seedingResult = new ArrayList<>();
        Requester<CardValues> requester = new Requester<>("https://db.ygoprodeck.com/api_internal/v7/cardvalues.php", "get", CardValues.class);


        CardValues cardValues = requester.sendJsonRequest();
        Map<String, String> attributes = new HashMap<String, String>() {{
            put("dark", "6a680ef1-03a3-4ea1-b014-904b1303197e");
            put("divine", "f30ab178-0d38-4eb4-817f-18dc9cfe78a8");
            put("earth", "b291e01f-52d0-4cce-95aa-5c2045784a03");
            put("fire", "0fe96d53-b76b-49fa-b973-bca027ecf8f1");
            put("light", "7faa16cd-4faf-4a5d-8b05-cdc87720ceb3");
            put("spell", "ced26349-9da0-44c8-8518-41db3a9e3d22");
            put("trap", "fd6f2b5e-1cab-4b04-94af-7fa03c7c7fae");
            put("water", "af0c6a62-4671-492e-b9f9-96d842bc80c9");
            put("wind", "152a82ff-1e38-4203-9f08-0a796fed4b5a");
        }};

        if (cardValues != null) {
            for (String attribute : cardValues.getMONSTER().getAttributes()) {
                String attributeImageId = attributes.get(attribute.toLowerCase());

                boolean savingResult = this.attributeService.insertAttribute(attribute, attributeImageId);
                seedingResult.add(String.format("Insert <Attribute>, Result => %b", savingResult));
            }
            //Image upload for races is skipped for now
            for(String race : cardValues.getMONSTER().getRace()){
                boolean savingResult = this.raceService.insertRace(race, null);
                seedingResult.add(String.format("Insert <Race>, Result => %b", savingResult));
            }
        }

        return new ResponseEntity<>(cardValues, HttpStatus.OK);
    }

}
