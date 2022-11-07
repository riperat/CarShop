package com.example.carshop.controllers.api.shop;

import com.example.carshop.data.entity.Car;
import com.example.carshop.services.interfaces.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarApiController {

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
    public Car createCar(@RequestBody Car car) {
        return (Car) carService.create(car);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/car/{id}")
    public Car updateSchool(@PathVariable("id") long id, @RequestBody Car car) {
        return (Car) carService.updateCar(id, car);
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
