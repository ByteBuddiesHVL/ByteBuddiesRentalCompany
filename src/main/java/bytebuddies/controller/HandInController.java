package bytebuddies.controller;

import bytebuddies.entities.Reservations;
import bytebuddies.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
public class HandInController {

    @Autowired
    private ReservationService resServ;

    @GetMapping("/lever")
    public String getHandIn(Model model) {
        model.addAttribute("reservations", resServ.getReservationsBefore());
        return "innlever";
    }

    @PostMapping("/lever")
    public String handIn(
            @RequestParam("reservation") Integer resId,
            RedirectAttributes attributes
    ) {
        Reservations reserv = resServ.getById(resId);

        String errorMessage = validateReservation(reserv);
        if (errorMessage != null) attributes.addFlashAttribute("error", errorMessage);
        else {
            resServ.handIn(reserv);
            attributes.addFlashAttribute("success", "Bilen ble levert inn!");
        }
        return "redirect:/lever";
    }

    public String validateReservation(Reservations reserv) {
        if (reserv == null) return "Ugyldig reservasjon";
        if (LocalDateTime.now().isBefore(reserv.getStartDate())) return "Reservasjonen har ikke begynt";

        return null;
    }

}
