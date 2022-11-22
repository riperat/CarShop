package com.example.carshop.controllers.view;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/success")
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        final String successMessage = "Successfully created Appointment!";
        model.addAttribute("temp", successMessage);
        return "success.html";
    }
}
