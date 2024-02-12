package bytebuddies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bytebuddies.entities.Post;
import bytebuddies.service.LocationService;
import bytebuddies.service.PostService;
import bytebuddies.service.UserService;

@Controller
public class RegisterUserController {

    @Autowired
    private LocationService locServ;
    @Autowired
    private UserService userServ;
    @Autowired
    private PostService postServ;

    @GetMapping("/registrer")
    public String registerCar() {
        return "registrer";
    }

    @PostMapping("/lagre-bruker")
    public String addCar(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "surname") String surName,
        @RequestParam(name = "phone") String phone,
        @RequestParam(name = "address") String address,
        @RequestParam(name = "postnum") String postNum,
        RedirectAttributes attributes
    ) {
        Post post = postServ.getPost(postNum);
        String errorMessage = validateUser(name, surName, phone, address, post);
        if (errorMessage != null) attributes.addFlashAttribute("error", errorMessage);
        else {
            userServ.register(phone, name, surName, address, post);
            attributes.addFlashAttribute("success", "Bruker registrert!");
        }

        return "redirect:/registrer";
    }

    public String validateUser(String name, String surName, String phone, String address, Post post) {
        if (post == null) return "Dette postnummeret er ikke registrert";
        if (!name.matches("^[A-ZØÆÅ][A-ZÆØÅa-zæøå -]{1,19}$")) return "Ugyldig fornavn";
        if (!surName.matches("^[A-ZØÆÅ][A-ZÆØÅa-zæøå-]{1,19}$")) return "Ugyldig etternavn";
        if (!phone.matches("^\\d{8}$")) return "Ugyldig telefon nummer";
        if (!address.matches("^[a-zæøåA-ZÆØÅ -]{5,30} \\d{1,4}[A-Za-z]?$")) return "Ugyldig addresse";

        return null;
    }

}
