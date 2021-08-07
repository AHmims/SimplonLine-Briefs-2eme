package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.CardInfo;
import ahmims.scuffed_BAKURA.dto.CardValues;
import ahmims.scuffed_BAKURA.model.*;
import ahmims.scuffed_BAKURA.repository.RoleRepository;
import ahmims.scuffed_BAKURA.security.JwtManager;
import ahmims.scuffed_BAKURA.service.*;
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
    private final CarteService carteService;
    private final MonsterService monsterService;
    private final ImageService imageService;
    private final ArchetypeService archetypeService;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public Test(MemberService MemberService, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtManager jwtManager, ModelMapper modelMapper, RaceService raceService, AttributeService attributeService,CarteService carteService,MonsterService monsterService, ImageService imageService, ArchetypeService archetypeService) {
        this.MemberService = MemberService;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
        this.raceService = raceService;
        this.attributeService = attributeService;
        this.carteService = carteService;
        this.monsterService = monsterService;
        this.imageService = imageService;
        this.archetypeService = archetypeService;
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

    @PostMapping("/api/seed/roles")
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

    @PostMapping("/api/seed/race_attr")
    public ResponseEntity<?> seedRA() {
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
            for (String race : cardValues.getMONSTER().getRace()) {
                boolean savingResult = this.raceService.insertRace(race, null);
                seedingResult.add(String.format("Insert <Race>, Result => %b", savingResult));
            }
        }

        return new ResponseEntity<>(seedingResult, HttpStatus.OK);
    }

    @PostMapping("/api/seed/cards")
    public ResponseEntity<?> seedC() {
        ArrayList<String> seedingResult = new ArrayList<>();
        Requester<CardInfo> requester = new Requester<>("https://db.ygoprodeck.com/api/v7/cardinfo.php", "get", CardInfo.class);


        CardInfo cardInfo = requester.sendJsonRequest();

        System.out.println("==========|Seed DB with cards|>");
        for (int i = 0; i < cardInfo.getData().length; i++) {
            System.out.printf("---<%d : %d>---%n", i, cardInfo.getData().length);
            CardInfo.CardData cardData = cardInfo.getData()[i];

            if(carteService.cardExists(cardData.getId())){
                System.out.printf("=> Card %d already exists%n", cardData.getId());
                continue;
            }

            Image cardImage = this.imageService.insertSingle(cardData.getCard_images()[0].getImage_url());

            if(cardImage == null){
                System.out.printf("=> Card image <%s> couldn't be saved%n", cardData.getCard_images()[0].getImage_url());
                continue;
            }

            if (cardData.getType().toLowerCase().contains("monster")){
                Archetype archetype = this.archetypeService.assertArchetype(cardData.getType());
                Attribute attribute = null;
                Race race = null;

                Monster monster = new Monster(cardData.getName(),cardData.getDesc(), cardData.getId(), cardData.getType(), cardImage, archetype, null, cardData.getAtk(),cardData.getDef(),cardData.getLevel(), cardData.getScale() == 0 ? cardData.getLinkval() : cardData.getScale(), attribute, race);
            }
        }

        return new ResponseEntity<>(cardInfo, HttpStatus.OK);
    }
}
