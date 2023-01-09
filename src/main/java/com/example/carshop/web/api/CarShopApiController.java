package com.example.carshop.web.api;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.dto.CreateCarShopDTO;
import com.example.carshop.web.dto.UpdateCarDTO;
import com.example.carshop.web.dto.UpdateCarShopDTO;
import com.example.carshop.web.view.model.CreateCarShopViewModel;
import com.example.carshop.web.view.model.CreateCarViewModel;
import com.example.carshop.web.view.model.UpdateCarShopViewModel;
import com.example.carshop.web.view.model.UpdateCarViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CarShopApiController {
    private final ModelMapper modelMapper;

    @Autowired
    private final CarShopService carShopService;

    @GetMapping(value = "/api/carShop")
    public List<CarShop> getCarShops() {
        return carShopService.getShops();
    }

    @GetMapping(value = "/api/carShop/{id}")
    public CarShop getCarShop(@PathVariable("id") int id) {
        return carShopService.getShop(id);
    }

    @PostMapping(value = "/api/carShop")
    public CarShop createCarShop(@RequestBody CreateCarShopViewModel carShopViewModel) {
        return carShopService.create(modelMapper.map(carShopViewModel, CreateCarShopDTO.class));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/carShop/{id}")
    public CarShop updateCarShop(@PathVariable("id") long id, @RequestBody UpdateCarShopViewModel carShopViewModel) {
        return carShopService.updateShop(id, modelMapper.map(carShopViewModel, UpdateCarShopDTO.class));
    }

    @GetMapping(value = "/api/carShop/delete/{id}")
    public void deleteCarShop(@PathVariable long id) {
        carShopService.deleteShop(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/carShop/{carPreferences}")
    public List<CarShop> getCarShopByBrand(@PathVariable("carPreferences") String carPreferences) {
        return carShopService.findAllByCarPreferences(carPreferences);
    }
}
