package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ApprenantService;
import service.ReservationService;

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
    public String postAdminReservationsValidator(@RequestParam String _id, ModelMap model) {
        //model.addAttribute("message", "welcome welcome");
        System.out.println(_id);
        return "admin-reservations";
    }
}
