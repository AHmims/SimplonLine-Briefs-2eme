package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Signup {
    @GetMapping("/register")
    public String getHome(ModelMap model) {
        //model.addAttribute("message", "welcome spring");
        return "register";
    }

    @PostMapping("/register")
    public String postHome(ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        return "register";
    }
}
