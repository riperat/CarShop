package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.services.interfaces.QualificationsService;
import com.example.carshop.web.dto.CreateQualDTO;
import com.example.carshop.web.view.model.CreateQualViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/qual")
public class QualificationController {
    ModelMapper modelMapper;
    QualificationsService qualificationsService;

    @GetMapping("/create-qualification")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("qualification", new Qualifications());
        return "/qual/create-qualification";
    }

    @PostMapping("/create")
    public String createCarShop(@ModelAttribute CreateQualViewModel qual, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/shops/create-qualification";
        }

        qualificationsService.create(modelMapper.map(qual, CreateQualDTO.class));
        return "redirect:/shops";
    }

}
