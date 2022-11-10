package com.example.carshop.controllers.view;

import com.example.carshop.data.entity.Car;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.RepairdoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private CarService carService;
    private RepairdoneService repairdoneService;

    @GetMapping
    public String getCars(Model model) {
        final List<Car> cars = carService.getCars();
        model.addAttribute("cars", cars);
        return "/cars/cars.html";
    }

    @GetMapping("/create-car")
    public String showCreateCarsForm(Model model) {
        model.addAttribute("car", new Car());
        return "/cars/create-car";
    }

    @PostMapping("/create")
    public String createCars(@ModelAttribute Car car) {
        carService.create(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit-car/{id}")
    public String showEditCarsForm(Model model, @PathVariable Long id) {
        model.addAttribute("car", carService.getCar(id));
        return "/cars/edit-car";
    }

    //TODO
    @GetMapping("/car-history/{id}")
    public String showCarHistoryForm(Model model, @PathVariable Long id) {
        model.addAttribute("repairsDone", repairdoneService.findAllByCar(carService.getCar(id)));

        return "/cars/car-history";
    }

    @PostMapping("/update/{id}")
    public String updateCars(Model model, @PathVariable long id, Car car) {
        carService.updateCar(id, car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
