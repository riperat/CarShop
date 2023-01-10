package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.User;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.RepairdoneService;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.dto.UpdateCarDTO;
import com.example.carshop.web.view.model.CreateCarViewModel;
import com.example.carshop.web.view.model.UpdateCarViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final ModelMapper modelMapper;

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
        model.addAttribute("car", new CreateCarViewModel());
        return "/cars/create-car";
    }

    @PostMapping("/create")
    public String createCars(@Valid @ModelAttribute("car") CreateCarViewModel car, BindingResult bindingResult, @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "/cars/create-car";
        }
        car.setUser(Set.of(user));
        carService.create(modelMapper.map(car, CreateCarDTO.class));
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
    public String updateCars(@PathVariable long id, @AuthenticationPrincipal User user, @Valid @ModelAttribute("car") UpdateCarViewModel car, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/cars/edit-car";
        }
        //for some reason cars cannot be upgraded so delete and create new car with same id
        carService.deleteCar(id);

        car.setUser(Set.of(user));
        carService.create(modelMapper.map(car, CreateCarDTO.class));
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }
}
