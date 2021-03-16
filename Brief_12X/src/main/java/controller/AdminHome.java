package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminHome {
    @GetMapping("/admin")
    public String getHome(ModelMap model) {
        //model.addAttribute("message", "welcome spring");
        return "admin-home";
    }

    @PostMapping("/admin")
    public String postHome(ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        return "admin-home";
    }
}
