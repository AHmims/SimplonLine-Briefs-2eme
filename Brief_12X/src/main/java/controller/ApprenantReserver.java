package controller;

import model.Apprenant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.EmplacementService;
import service.LocalService;
import service.ReservationService;

import javax.servlet.http.HttpSession;

@Controller
public class ApprenantReserver {
    @GetMapping("/apprenant/reserver")
    public String getApprenantReserver(ModelMap model) {
        EmplacementService emplacementService = new EmplacementService();
        LocalService localService = new LocalService();
        //
        model.addAttribute("_emplacement_all", emplacementService.getAll());
        model.addAttribute("_local_all", localService.getAll());
        return "learner-reservation";
    }

    @PostMapping("/apprenant/reserver")
    public String postApprenantReserver(@RequestParam String _local, @RequestParam String _emplacement, @RequestParam String _date, ModelMap model, HttpSession session) {
        ReservationService reservationService = new ReservationService();
        model.addAttribute("_insert_res", reservationService.insert((Apprenant) session.getAttribute("_user_data"), _date, _emplacement, _local));
        return "learner-reservation";
    }
}
