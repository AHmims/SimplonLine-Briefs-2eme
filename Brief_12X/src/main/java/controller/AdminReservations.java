package controller;

import model.Administrateur;
import model.Apprenant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.ApprenantService;
import service.ReservationService;

import javax.servlet.http.HttpSession;

@Controller
public class AdminReservations {
    @GetMapping("/admin/reservations")
    public String getAdminReservations(ModelMap model) {
        ReservationService reservationService = new ReservationService();
        //
        model.addAttribute("_reservations_all", reservationService.getAll(true));
        model.addAttribute("_reservations_hold", reservationService.getRequests());
        return "admin-reservations";
    }

    @PostMapping("/admin/reservations/validator")
    public ModelAndView postAdminReservationsValidator(@RequestParam String _action, @RequestParam String _id, ModelMap model, HttpSession session) {
        ReservationService reservationService = new ReservationService();
        model.addAttribute("ret_code", reservationService.validate((Administrateur) session.getAttribute("__user_data"), _id, _action));
        return new ModelAndView("redirect:/admin/reservations", model);
    }
}
