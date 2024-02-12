package bytebuddies.controller;

import bytebuddies.entities.Cars;
import bytebuddies.entities.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bytebuddies.service.CarService;
import bytebuddies.service.LocationService;

@Controller
public class RegisterController {

    @Autowired
    private LocationService locServ;
    @Autowired
    private CarService carServ;

    @GetMapping("/registrer-bil")
    public String registerCar(Model model) {

        model.addAttribute("locations", locServ.getAll());

        return "registrer-bil";
    }

    @PostMapping("/lagre-bil")
    public String addCar(
        @RequestParam(name = "regNum") String regNum,
        @RequestParam(name = "brand") String brand,
        @RequestParam(name = "color") String color,
        @RequestParam(name = "group") String group,
        @RequestParam(name = "km") Integer distDriven,
        @RequestParam(name = "locations") String location,
        RedirectAttributes attributes
    ) {
        Locations loc = locServ.getById(location);
        String errorMessage = validateCar(carServ.getById(regNum), brand, color, group, distDriven, loc);
        if (errorMessage != null) attributes.addFlashAttribute("error", errorMessage);
        else {
            carServ.saveCar(regNum, brand, color, group, distDriven, loc);
            attributes.addFlashAttribute("success", "Bilen " + regNum + " har blitt registrert");
        }

        return "redirect:/registrer-bil";
    }

    public String validateCar(Cars car, String brand, String color, String group, Integer distDriven, Locations locations) {
        if (locations == null) return "Dette utleiekontoret finnes ikke.";
        if (car != null) return "Det finnes allerede en bil med dette registreringsnummeret.";
        if (!group.matches("^[A-D]$")) return "Ugyldig gruppe";
        if (distDriven < 0 || distDriven > 9999999) return "Kilometer kjørt må være mellom 0 og 9 999 999.";
        if (color.length() < 2 || color.length() > 50) return "Ugyldig farge";
        if (brand.length() < 2 || brand.length() > 30) return "Ugyldig merke";

        return null;
    }
}
