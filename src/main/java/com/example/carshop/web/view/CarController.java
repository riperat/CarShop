package com.example.carshop.web.view;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.User;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.RepairdoneService;
import com.example.carshop.services.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private CarService carService;
    private RepairdoneService repairdoneService;

    @GetMapping
    public String getCars(Model model, @AuthenticationPrincipal User user) {
        final List<Car> cars = carService.getCarsByUser(user);
        model.addAttribute("cars", cars);
        return "/cars/cars.html";
    }

    @GetMapping("/create-car")
    public String showCreateCarsForm(Model model) {
        model.addAttribute("car", new Car());
        return "/cars/create-car";
    }

    @PostMapping("/create")
    public String createCars(@ModelAttribute Car car, @AuthenticationPrincipal User user) {

        car.setUser(Set.of(user));
        carService.create(car);
        return "redirect:/cars";
    }

    @GetMapping("/edit-car/{id}")
    public String showEditCarsForm(Model model, @PathVariable Long id) {
        model.addAttribute("car", carService.getCar(id));
        return "/cars/edit-car";
    }

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
