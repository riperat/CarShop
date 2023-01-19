package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.services.interfaces.QualificationsService;
import com.example.carshop.web.dto.CreateQualDTO;
import com.example.carshop.web.dto.UpdateQualDTO;
import com.example.carshop.web.view.model.CreateQualViewModel;
import com.example.carshop.web.view.model.UpdateQualViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/qual")
public class QualificationController {
    ModelMapper modelMapper;

    @Autowired
    QualificationsService qualificationsService;

    @GetMapping
    public String getCars(Model model) {
        final List<Qualifications> qualifications = qualificationsService.getAllQualifications();
        model.addAttribute("qualification", qualifications);
        return "/qual/qual-menu.html";
    }

    @GetMapping("/create-qualification")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("qualification", new Qualifications());
        return "/qual/create-qualification";
    }

    @PostMapping("/create")
    public String createCarShop(@Valid @ModelAttribute("qualification") CreateQualViewModel qual, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/qual/create-qualification";
        }

        qualificationsService.create(modelMapper.map(qual, CreateQualDTO.class));
        return "redirect:/qual";
    }

    @GetMapping("/edit-qualification/{id}")
    public String showEditCarShopForm(Model model, @PathVariable Long id) {
        model.addAttribute("qualification", new Qualifications());
        return "/qual/edit-qualification";
    }

    @PostMapping("/update/{id}")
    public String updateCars(@PathVariable Long id, @Valid @ModelAttribute("qualification") UpdateQualViewModel carShop, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/qual/create-qualification";
        }

        qualificationsService.updateQualification(id, modelMapper.map(carShop, UpdateQualDTO.class));
        return "redirect:/qual";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        qualificationsService.deleteQualification(id);
        return "redirect:/qual";
    }
}
