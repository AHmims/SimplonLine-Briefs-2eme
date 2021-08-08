package ahmims.scuffed_BAKURA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {
    @GetMapping("")
    public String displayHomePage(ModelMap model) {
        model.addAttribute("eventName", "FIFA 2018");
        return "index";
    }

}
