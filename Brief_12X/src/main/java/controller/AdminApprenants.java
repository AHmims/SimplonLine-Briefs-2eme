package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ApprenantService;

@Controller
public class AdminApprenants {
    @GetMapping("/admin/apprenants")
    public String getHome(ModelMap model) {
        ApprenantService apprenantService = new ApprenantService();
        model.addAttribute("_app_count_active", apprenantService.getAll(true));
        model.addAttribute("_app_count_inactive", apprenantService.getAll(false));
        return "admin-learners";
    }

    @PostMapping("/admin/apprenants/validator")
    public ModelAndView postHomeValidator(@RequestParam String _action, @RequestParam String _id, ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        System.out.println(_action);
        return new ModelAndView("redirect:/admin/apprenants", model);
    }

    @PostMapping("/admin/apprenants/manager")
    public ModelAndView postHomeManager(@RequestParam String _id, ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        ApprenantService apprenantService = new ApprenantService();
        int deleteRes = apprenantService.remove(_id);
        System.out.println(deleteRes);
        model.addAttribute("_remove_res", deleteRes);
        return new ModelAndView("redirect:/admin/apprenants", model);
    }
}
