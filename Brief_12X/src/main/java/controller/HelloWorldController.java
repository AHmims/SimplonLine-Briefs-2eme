package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sayHello(ModelMap model) {

        model.addAttribute("message", "welcome spring");

        return "welcome";
    }

    @RequestMapping(value = "/helloagain", method = RequestMethod.GET)
    public String sayHellothere(ModelMap model) {

        model.addAttribute("message", "welcome welcome");

        return "welcome";
    }

}
