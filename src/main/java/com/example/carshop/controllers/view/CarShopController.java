package com.example.carshop.controllers.view;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;
import com.example.carshop.services.interfaces.RepairdoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shops")
public class CarShopController {
    private CarShopService carShopService;

    @GetMapping
    public String getCarShops(Model model) {
        final List<CarShop> cars = carShopService.getShops();
        model.addAttribute("shops", cars);
        return "/shops/shops.html";
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
