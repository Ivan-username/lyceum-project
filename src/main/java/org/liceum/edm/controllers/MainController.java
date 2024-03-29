package org.liceum.edm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("api/v1/main")
    public String home(Model model){
        model.addAttribute("title", "Main page.");
        return "main";
    }
}
