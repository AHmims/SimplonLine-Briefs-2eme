package controller;

import model.Administrateur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CalendrierService;
import service.ReservationService;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class AdminCalendrier {
    @GetMapping("/admin/calendrier")
    public String getAdminCalendrier(@RequestParam(required = false) String idCalendrier, ModelMap model) {
        CalendrierService calendrierService = new CalendrierService();
        ReservationService reservationService = new ReservationService();
        //
        model.addAttribute("_dates", calendrierService.getDates());
        if (idCalendrier != null) {
            model.addAttribute("_reservations", reservationService.getByCalendrier(idCalendrier));
        } else {
            model.addAttribute("_reservations", reservationService.getByFirstCalendrier());
        }
        return "admin-calendrier";
    }

    @PostMapping("/admin/calendrier")
    public ModelAndView postAdminCalendrier(@RequestParam Map<String, String> requestParams, ModelMap model, HttpSession session) {
        CalendrierService calendrierService = new CalendrierService();
        int res = calendrierService.insert(requestParams, (Administrateur) session.getAttribute("__user_data"));
        model.addAttribute("ret_code", res);
        return new ModelAndView("redirect:/admin/calendrier", model);
    }
}
