package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApprenantReserver {
    @GetMapping("/apprenant/reserver")
    public String getHome(ModelMap model) {
        //model.addAttribute("message", "welcome spring");
        return "learner-reservation";
    }

    @PostMapping("/apprenant/reserver")
    public String postHome(ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        return "learner-reservation";
    }
}
