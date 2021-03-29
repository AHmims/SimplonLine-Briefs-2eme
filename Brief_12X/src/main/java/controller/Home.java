package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Home {
    @GetMapping("/")
    public String getHome(ModelMap model, HttpSession session) {
        return "index";
    }
}
