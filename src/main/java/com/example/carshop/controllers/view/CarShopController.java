package com.example.carshop.controllers.view;

import com.example.carshop.data.entity.*;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.services.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shops")
public class CarShopController {
    private CarShopService carShopService;
    private RepairmanQService repairmanQService;
    private RepairmanService repairmanService;

    @GetMapping
    public String getCarShops(Model model) {
        final List<CarShop> shops = carShopService.getShops();
        model.addAttribute("shops", shops);
        return "/shops/shops.html";
    }

    @GetMapping("/shop/{id}")
    public String showCarHistoryForm(Model model, @PathVariable Long id) {
        final List<Repairman> repairmen =  repairmanService.findAllByCarShop(carShopService.getShop(id));
        final List<Qualifications> qualifications =  new ArrayList<>();


        for (Repairman rep : repairmen){

            final List<RepairmanQ> repairmanQS =  repairmanQService.findAllByRepairman(rep);

        }

//        repairmen.forEach((repairman) -> qualifications.add());

        model.addAttribute("repairmen", repairmen);
        model.addAttribute("repairmen", repairmen);
        return "/shops/shop-view";
    }

    @GetMapping("/create-carShop")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("carShop", new CarShop());
        return "/shops/create-carShop";
    }

    @PostMapping("/create")
    public String createCarShops(@ModelAttribute CarShop carShop) {
        carShopService.create(carShop);
        return "redirect:/shops";
    }

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
