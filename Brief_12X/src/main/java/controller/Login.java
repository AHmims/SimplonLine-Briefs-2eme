package controller;

import model.Apprenant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.AuthentificationService;

import javax.servlet.http.HttpSession;

@Controller
public class Login {
    @GetMapping("/auth/login")
    public String getLogin(ModelMap model, HttpSession session) {
        //model.addAttribute("message", "welcome spring");
        return "login";
    }

    @PostMapping("/auth/login/admin")
    public ModelAndView postLoginAdmin(@RequestParam String userEmail, @RequestParam String userPass, ModelMap model, HttpSession session) {
        //model.addAttribute("message", "welcome welcome");
        AuthentificationService authentificationService = new AuthentificationService();
        int res = authentificationService.signIn(userEmail, userPass, session);
        if(res != 13) {
            model.addAttribute("ret_code", res);
            return new ModelAndView("redirect:/auth/login", model);
        }else{
//            return "redirect:/";
            return new ModelAndView("redirect:/admin", model);
        }
    }

    @ResponseBody
    @PostMapping("/auth/login/apprenant")
    public String postLoginApprenant(@RequestParam String idToken, ModelMap model, HttpSession session) {
        //model.addAttribute("message", "welcome welcome");
        AuthentificationService authentificationService = new AuthentificationService();
        int res = authentificationService.signIn(idToken, session);
        return res + "";
    }
}
