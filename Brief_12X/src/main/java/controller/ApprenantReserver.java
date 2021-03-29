package controller;

import model.Apprenant;
import model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.EmplacementService;
import service.LocalService;
import service.ReservationService;
import util.Parser;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

@Controller
public class ApprenantReserver {
    @GetMapping("/apprenant/reserver")
    public String getApprenantReserver(ModelMap model, HttpSession session) {
        ReservationService reservationService = new ReservationService();
        Reservation reservation = reservationService.getByDateForUser((Apprenant) session.getAttribute("__user_data"), Parser.toDateWithNoTime(new Date()));
        if (reservation == null || reservation.isValideReservation()) {
            EmplacementService emplacementService = new EmplacementService();
            LocalService localService = new LocalService();
            //
            model.addAttribute("_emplacement_all", emplacementService.getAll());
            model.addAttribute("_local_all", localService.getAll());
            return "learner-reservation";
        } else return "learner-reservation-hold";
    }

    @PostMapping("/apprenant/reserver")
    public ModelAndView postApprenantReserverAdd(@RequestParam Map<String, String> requestParams, ModelMap model, HttpSession session) {
        if (requestParams.size() != 3) {
            /*
            ERROR CODES:
            555: data received is invalid
             */
            model.addAttribute("ret_code", 555);
        } else {
            ReservationService reservationService = new ReservationService();
            model.addAttribute("ret_code", reservationService.insert((Apprenant) session.getAttribute("__user_data"), requestParams.get("_date"), requestParams.get("_emplacement"), requestParams.get("_local")));
        }
        return new ModelAndView("redirect:/apprenant/reserver", model);
    }

    @PostMapping("/apprenant/reserver/remove")
    public ModelAndView postApprenantReserverRemove(ModelMap model, HttpSession session) {
        ReservationService reservationService = new ReservationService();
        model.addAttribute("ret_code", reservationService.cancel((Apprenant) session.getAttribute("__user_data")));
        return new ModelAndView("redirect:/apprenant/reserver", model);
    }
}
