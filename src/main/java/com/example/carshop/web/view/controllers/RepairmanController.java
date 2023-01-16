package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.services.interfaces.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.carshop.util.HibernateUtil.getAllQualificationNames;
import static com.example.carshop.util.HibernateUtil.getAllShopsNames;

@Controller
@AllArgsConstructor
@RequestMapping("/repairmen")
public class RepairmanController {
    private final ModelMapper modelMapper;

    private CarService carService;
    private CarShopService carShopService;
    private RepairmanService repairmanService;
    private RepairdoneService repairdoneService;
    private QualificationsService qualificationsService;


    @GetMapping("/create-repairman")
    public String showCreateCarShopsForm(Model model) {
        final Set<String> qualificationNamesList = getAllQualificationNames(qualificationsService);
        final Set<String> shopsNameList = getAllShopsNames(carShopService);

        model.addAttribute("qualifications", qualificationNamesList);
        model.addAttribute("shopName", shopsNameList);
        model.addAttribute("repairman", new Repairman());

        return "/repairmen/create-repairman";
    }

    @PostMapping("/create")
    public String createCarShop(@RequestParam("name") String name, @RequestParam("shopName") String shopName, @RequestParam("qualifications") List<String> qualifications) {
        Repairman repairman = new Repairman();
        Set<Qualifications> quals = new HashSet<>();
        for (String qual :
                qualifications) {
            quals.add(qualificationsService.getQualificationByName(qual));

        }

        repairman.setCarShop(carShopService.findByName(shopName));
        repairman.setName(name);
        repairman.setQualifications(quals);
        repairmanService.create(repairman);
        return "redirect:/shops";
    }


}
