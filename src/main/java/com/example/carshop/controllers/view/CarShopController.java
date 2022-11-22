package com.example.carshop.controllers.view;

import com.example.carshop.data.entity.*;
import com.example.carshop.services.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shops")
public class CarShopController {
    private CarService carService;
    private CarShopService carShopService;
    private RepairmanQService repairmanQService;
    private RepairmanService repairmanService;
    private RepairdoneService repairdoneService;

    @GetMapping
    public String getCarShops(Model model) {
        final List<CarShop> shops = carShopService.getShops();
        model.addAttribute("shops", shops);
        return "/shops/shops.html";
    }

    @GetMapping("/shop-view/{id}")
    public String shopView(Repairdone repairdone, Model model, @PathVariable Long id) {
        final List<Repairman> repairmen = repairmanService.findAllByCarShop(carShopService.getShop(id));

        final List<String> qualificationNamesList = new ArrayList<>();

        for (Repairman rep : repairmen) {
            final List<RepairmanQ> repairmanQS = repairmanQService.findAllByRepairman(rep);

            repairmanQS.forEach((RQ) -> qualificationNamesList.add(RQ.getQualifications().getQualificationName() + " "));
        }

        model.addAttribute("qualifications", qualificationNamesList);
        model.addAttribute("repairdone", repairdone);

        return "/shops/shop-view";
    }

    @GetMapping("/create-repair")
    public String showCreateRepairForm(Model model) {
        final List<Repairdone> repairs = new ArrayList<>();
        repairs.addAll(repairdoneService.findAllByCar(carService.getCar(1)));
        final List<Date> dates = new ArrayList<>();

        for (Repairdone rep : repairs) {
            dates.add(rep.getDateStarted());
        }
        model.addAttribute("dates", dates);
        model.addAttribute("repair", new Repairdone());
        return "/shops/create-repair";
    }

//    //TODO add current user
//    @PostMapping("/createRepair")
//    public String reservationUpdate(@ModelAttribute Repairdone repairdone) {
//        repairdoneService.create(repairdone);
//        return "redirect:/shops";
//    }

    @PostMapping("/create")
    public String createCars(@ModelAttribute Repairdone repairdone) {
        repairdoneService.create(repairdone);
        return "redirect:/cars";
    }

    @GetMapping("/success")
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("temp", "repair reservation");
        return "/success";
    }

    @GetMapping("/create-carShop")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("carShop", new CarShop());
        return "/shops/create-carShop";
    }

//    @PostMapping("/create")
//    public String createCarShops(@ModelAttribute CarShop carShop) {
//        carShopService.create(carShop);
//        return "redirect:/shops";
//    }

    @GetMapping("/edit-carShop/{id}")
    public String showEditCarsForm(Model model, @PathVariable Long id) {
        model.addAttribute("carShop", carShopService.getShop(id));
        return "/shops/edit-carShop";
    }

    @PostMapping("/update/{id}")
    public String updateCars(Model model, @PathVariable long id, CarShop carShop) {
        carShopService.updateShop(id, carShop);
        return "redirect:/shops";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        carShopService.deleteShop(id);
        return "redirect:/cars";
    }
}
