package bytebuddies.controller;

import bytebuddies.entities.Cars;
import bytebuddies.entities.Locations;
import bytebuddies.entities.Users;
import bytebuddies.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private CarService carServ;

    @Autowired
    private LocationService locServ;

    @Autowired
    private PostService postServ;

    @Autowired
    private UserService userServ;

    @Autowired
    private ReservationService reservServ;

    @GetMapping("/reserver")
    public String reserve(
            @RequestParam(name = "startDate") LocalDateTime startDate,
            @RequestParam(name = "endDate") LocalDateTime endDate,
            @RequestParam(name = "user") String user,
            @RequestParam(name = "group") String group,
            @RequestParam(name = "startLocation") String startLocation,
            Model model
    ) {
        int price = 0;
        int groupNum = group.charAt(0) - 'A';
        if (groupNum == 0) {
            price = 650;
        } else if (groupNum == 1) {
            price = 800;
        } else if (groupNum == 2) {
            price = 1000;
        } else {
            price = 1200;
        }
        Locations loc = locServ.getById(startLocation);
        model.addAttribute("cars", carServ.getAvailableAtLocation(group, loc, startDate, endDate));
        model.addAttribute("locations", locServ.getAll());
        model.addAttribute("user", user);
        model.addAttribute("startDate", startDate.toString());
        model.addAttribute("endDate", endDate.toString());
        model.addAttribute("price", price * ChronoUnit.DAYS.between(startDate, endDate));
        return "reserver";
    }

    @GetMapping("/start-reservasjon")
    public String startReservation(
            Model model
    ) {
        model.addAttribute("users", userServ.getAllUsers());
        model.addAttribute("locations", locServ.getAll());
        return "start-reservasjon";
    }

    @PostMapping("/lagre-reservasjon")
    public String saveReservastion(
            @RequestParam(name = "user") String user,
            @RequestParam(name = "cardNumber") String cardNumber,
            @RequestParam(name = "cardCode") String cardCode,
            @RequestParam(name = "startDate") LocalDateTime startDate,
            @RequestParam(name = "endDate") LocalDateTime endDate,
            @RequestParam(name = "car") String car,
            @RequestParam(name = "location") String location,
            @RequestParam(name = "price") Integer amount,
            RedirectAttributes attributes
    ) {
        Users userU = userServ.getById(user);
        Cars carC = carServ.getById(car);
        Locations loc = locServ.getById(location);
        String errorMessage = validateReservation(userU, cardNumber, cardCode, carC, loc, startDate, endDate);
        if (errorMessage != null) attributes.addFlashAttribute("error", errorMessage);
        else {
            reservServ.reserve(userU, cardNumber, cardCode, false, amount, startDate, endDate, carC, loc);
            attributes.addFlashAttribute("success", "Reservasjonen var vellykket!");
        }

        return "redirect:/";
    }

    public String validateReservation(Users user, String cardNumber, String cardCode, Cars car, Locations location, LocalDateTime startDate, LocalDateTime endDate) {
        if (user == null) return "Ugyldig bruker";
        if (!cardNumber.matches("^\\d{4} ?\\d{4} ?\\d{4} ?\\d{4}$")) return "Ugyldig kortnummer";
        if (!cardCode.matches("^\\d{3}$")) return "Ugyldig kortkode";
        if (location == null) return "Ugyldig lokasjon";
        if (!car.isAvailableBetween(startDate, endDate)) return "Bilen er ikke tilgjengelig i tidsintervallet";

        return null;
    }
}
