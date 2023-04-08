package org.liceum.edm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
    @GetMapping("api/v1/registration")
    public String home(Model model){
        model.addAttribute("var", "tipa_rabotaet");
        return "registration";
    }
}
