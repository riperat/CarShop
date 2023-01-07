package com.example.carshop.web.api;

import com.example.carshop.data.entity.Car;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.dto.UpdateCarDTO;
import com.example.carshop.web.view.model.CreateCarViewModel;
import com.example.carshop.web.view.model.UpdateCarViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
@AllArgsConstructor
public class CarApiController {
    private final ModelMapper modelMapper;

    @Autowired
    private final CarService carService;

    @GetMapping(value = "/api/car")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping(value = "/api/car/{id}")
    public Car getCar(@PathVariable("id") int id) {
        return carService.getCar(id);
    }

    @PostMapping(value = "/api/car")
    public Car createCar(@RequestBody CreateCarViewModel car) {
        return carService.create(modelMapper.map(car, CreateCarDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/car/{id}")
    public Car updateSchool(@PathVariable("id") long id, @RequestBody UpdateCarViewModel car) {
        return carService.updateCar(id, modelMapper.map(car, UpdateCarDTO.class));
    }

    @GetMapping(value = "/api/schools/{brand}")
    public void deleteCar(@PathVariable long id) {
        carService.deleteCar(id);
    }

    @RequestMapping(value = "/api/schools")
    public List<Car> getCarsByBrand(String brand) {
        return carService.getCarsByBrand(brand);
    }

}
