package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.services.interfaces.*;
import com.example.carshop.web.dto.CreateCarShopDTO;
import com.example.carshop.web.view.model.CreateCarShopViewModel;
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
@RequestMapping("/repairman")
public class RepairmanController {
    private final ModelMapper modelMapper;

    private CarService carService;
    private CarShopService carShopService;
    private RepairmanService repairmanService;
    private RepairdoneService repairdoneService;
    private QualificationsService qualificationsService;


    @GetMapping("/create-carShop")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("carShop", new CarShop());
        return "/shops/create-shop";
    }

    @PostMapping("/create")
    public String createCarShop(@ModelAttribute CreateCarShopViewModel createCarShopViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/shops/create-shop";
        }

        carShopService.create(modelMapper.map(createCarShopViewModel, CreateCarShopDTO.class));
        return "redirect:/shops";
    }



}
