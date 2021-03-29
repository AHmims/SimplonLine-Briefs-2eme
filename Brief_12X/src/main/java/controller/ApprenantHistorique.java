package controller;

import model.Administrateur;
import model.Apprenant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ReservationService;
import service.api.ServiceAdministrateur;
import service.api.ServiceReservation;

import javax.servlet.http.HttpSession;

@Controller
public class ApprenantHistorique {
    @GetMapping("/apprenant/reservations")
    public String getApprenantHistorique(@RequestParam(required = false) String type, ModelMap model, HttpSession session) {
        ReservationService reservationService = new ReservationService();
        model.addAttribute("_reservations", reservationService.getHistory((Apprenant) session.getAttribute("__user_data"), type != null ? type : "all"));
        return "learner-reservations";
    }

    @PostMapping("/apprenant/reservations")
    public String postApprenantHistorique(ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        return "learner-reservations";
    }
}
