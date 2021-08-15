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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelperController {

    private final MemberService MemberService;
    private final RoleRepository roleRepository;
    private final RaceService raceService;
    private final AttributeService attributeService;
    private final CarteService carteService;
    private final MonsterService monsterService;
    private final ImageService imageService;
    private final ArchetypeService archetypeService;
    private final SpellService spellService;
    private final TrapService trapService;
    private final AuthenticationManager authenticationManager;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public HelperController(MemberService MemberService, RoleRepository roleRepository, AuthenticationManager authenticationManager, JwtManager jwtManager, ModelMapper modelMapper, RaceService raceService, AttributeService attributeService, CarteService carteService, MonsterService monsterService, ImageService imageService, ArchetypeService archetypeService, SpellService spellService, TrapService trapService) {
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
        this.spellService = spellService;
        this.trapService = trapService;
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
            put("dark", "57208fb8-1ac7-4372-ba11-398b3a57e794");
            put("divine", "2f010c5a-1950-4d04-bd1a-63770d727c9c");
            put("earth", "941c1f64-b5e8-47e1-bda5-8b092e350e1f");
            put("fire", "01d6c229-e4be-4862-89d4-5c1535ee4fc2");
            put("light", "1e2ff60f-225a-4079-829a-bc0912f3dbd7");
            put("spell", "76fc0413-41f6-4ace-bf8b-d9dc530a9a54");
            put("trap", "3839005a-4342-4dc6-b629-1eba1548002e");
            put("water", "09f6d01d-f65c-4614-8f32-603b73eb2de2");
            put("wind", "7d9f6561-4214-41a9-b62f-8b1c29065115");
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
        ArrayList<String[]> seedingResult = new ArrayList<>();
        Requester<CardInfo> requester = new Requester<>("https://db.ygoprodeck.com/api/v7/cardinfo.php", "get", CardInfo.class);


        CardInfo cardInfo = requester.sendJsonRequest();

        System.out.println("==========|Seed DB with cards|>");
        for (int i = 0; i < cardInfo.getData().length; i++) {
            System.out.printf("---<%d : %d>---%n", i + 1, cardInfo.getData().length);
            CardInfo.CardData cardData = cardInfo.getData()[i];

            if (carteService.cardExists(cardData.getId())) {
                System.out.printf("=> Card %d already exists%n", cardData.getId());
                continue;
            }

            Image cardImage = this.imageService.insertSingle(cardData.getCard_images()[0].getImage_url());

            if (cardImage == null) {
                System.out.printf("=> Card image <%s> couldn't be saved%n", cardData.getCard_images()[0].getImage_url());
                continue;
            }

            Archetype archetype = this.archetypeService.assertArchetype(cardData.getType());
            Attribute attribute = this.attributeService.getAttributeByName(cardData.getAttribute());
            Race race = this.raceService.getRaceByName(cardData.getRace());

            Carte savedCarte = null;

            if (cardData.getType().toLowerCase().contains("monster")) {
                Monster monster = new Monster(cardData.getName(), cardData.getDesc(), cardData.getId(), cardData.getType(), cardImage, archetype, null, cardData.getAtk(), cardData.getDef(), cardData.getLevel(), cardData.getScale() == 0 ? cardData.getLinkval() : cardData.getScale(), attribute, race);
                savedCarte = this.monsterService.saveMonster(monster);
            }
            if (cardData.getType().toLowerCase().contains("spell")) {
                Spell spell = new Spell(cardData.getName(), cardData.getDesc(), cardData.getId(), cardData.getType(), cardImage, archetype, null);
                savedCarte = this.spellService.saveSpell(spell);
            }
            if (cardData.getType().toLowerCase().contains("trap")) {
                Trap trap = new Trap(cardData.getName(), cardData.getDesc(), cardData.getId(), cardData.getType(), cardImage, archetype, null);
                savedCarte = this.trapService.saveTrap(trap);
            }

            if (savedCarte == null) {
                System.out.printf("=> Card <%s> couldn't be saved%n", cardData.getId());
            }

            seedingResult.add(new String[]{cardData.getId() + "", (savedCarte != null) + ""});
        }

        return new ResponseEntity<>(seedingResult, HttpStatus.OK);
    }

    @GetMapping("/api/ping")
    public ResponseEntity<Boolean> ping() {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
