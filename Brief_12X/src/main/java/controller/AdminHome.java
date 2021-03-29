package controller;

import model.Calendrier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.ApprenantService;
import service.CalendrierService;
import service.LogService;
import service.ReservationService;

import java.util.Date;

@Controller
public class AdminHome {
    @GetMapping("/admin")
    public String getAdminHome(ModelMap model) {
        ReservationService reservationService = new ReservationService();
        CalendrierService calendrierService = new CalendrierService();
        ApprenantService apprenantService = new ApprenantService();
        LogService logService = new LogService();
        //
        Calendrier calendrier = calendrierService.getByDate(new Date());
        //
        model.addAttribute("_res_count_all", reservationService.getByCalendrier(calendrier).size());
        model.addAttribute("_res_count_onhold", reservationService.getByCalendrier(calendrier, false).size());
        model.addAttribute("_app_count_active", apprenantService.getAll(true).size());
        model.addAttribute("_app_count_inactive", apprenantService.getAll(false).size());
        model.addAttribute("_logs", logService.getLogs());
        return "admin-home";
    }
}
