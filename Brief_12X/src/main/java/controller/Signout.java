package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class Signout {
    @GetMapping("/signout")
    public ModelAndView getSignout(ModelMap model, HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/", model);
    }
}
