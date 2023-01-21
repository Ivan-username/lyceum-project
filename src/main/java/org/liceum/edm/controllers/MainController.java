package org.liceum.edm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("title", "Main page.\n Hello world");
        return "home";
    }
}
