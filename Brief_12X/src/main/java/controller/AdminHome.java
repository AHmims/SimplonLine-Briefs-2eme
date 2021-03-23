package controller;

import model.Calendrier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.ApprenantService;
import service.CalendrierService;
import service.ReservationService;

import java.util.Date;

@Controller
public class AdminHome {
    @GetMapping("/admin")
    public String getHome(ModelMap model) {
        ReservationService reservationService = new ReservationService();
        CalendrierService calendrierService = new CalendrierService();
        ApprenantService apprenantService = new ApprenantService();
        //
        Calendrier calendrier = calendrierService.getByDate(new Date());
        //
        model.addAttribute("_res_count_all", reservationService.getByCalendrier(calendrier).size());
        model.addAttribute("_res_count_onhold", reservationService.getByCalendrier(calendrier, false).size());
        model.addAttribute("_app_count_active", apprenantService.getAll(true).size());
        model.addAttribute("_app_count_inactive", apprenantService.getAll(false).size());
        return "admin-home";
    }

    @PostMapping("/admin")
    public String postHome(ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        return "admin-home";
    }
}
