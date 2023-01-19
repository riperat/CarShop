package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.User;
import com.example.carshop.services.interfaces.*;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.dto.CreateRepairmanDTO;
import com.example.carshop.web.dto.UpdateRepairmanDTO;
import com.example.carshop.web.view.model.CreateRepairmanViewModel;
import com.example.carshop.web.view.model.UpdateCarViewModel;
import com.example.carshop.web.view.model.UpdateRepairmanViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    private QualificationsService qualificationsService;

    @GetMapping
    public String getCars(Model model) {
        final List<Repairman> cars = repairmanService.getAllRepairmen();
        model.addAttribute("repairmen", cars);
        return "/repairmen/repairmen-menu.html";
    }

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
    @GetMapping("/edit-repairman/{id}")
    public String showEditCarsForm(Model model, @PathVariable Long id) {
        final Set<String> qualificationNamesList = getAllQualificationNames(qualificationsService);
        final Set<String> shopsNameList = getAllShopsNames(carShopService);

        model.addAttribute("qualifications", qualificationNamesList);
        model.addAttribute("shopName", shopsNameList);
        model.addAttribute("rep", repairmanService.getRepairman(id));
        return "/repairmen/edit-repairman";
    }

    @PostMapping("/update/{id}")
    public String updateCars(@PathVariable long id, @RequestParam("name") String name, @RequestParam("shopName") String shopName, @RequestParam("qualifications") List<String> qualifications) {

        //for some reason cars cannot be upgraded so delete and create new car with same id
        repairmanService.deleteRepairman(id);


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
        return "redirect:/repairmen";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        repairmanService.deleteRepairman(id);
        return "redirect:/repairmen";
    }

}
