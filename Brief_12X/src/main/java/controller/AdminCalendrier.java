package controller;

import model.Administrateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CalendrierService;
import service.ReservationService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminCalendrier {
    @GetMapping("/admin/calendrier")
    public String getCalendar(ModelMap model) {
        //model.addAttribute("message", "welcome spring");
        CalendrierService calendrierService = new CalendrierService();
        ReservationService reservationService = new ReservationService();
        model.addAttribute("_dates", calendrierService.getDates());
        //model.addAttribute("_dates", calendrierService.getDates());
        return "admin-calendrier";
    }

    @PostMapping("/admin/calendrier")
    public String postCalendar(@RequestParam Map<String, String> requestParams, ModelMap model, HttpSession session) {
        //model.addAttribute("message", "welcome welcome");
        CalendrierService calendrierService = new CalendrierService();
        int res = calendrierService.insert(requestParams, (Administrateur) session.getAttribute("__user_data"));
        System.out.println(res);
        return "admin-calendrier";
    }
}