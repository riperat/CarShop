package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.repository.CarRepository;
import com.example.carshop.data.repository.CarShopRepository;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarShopImpl implements CarShopService {
    private final CarShopRepository carShopRepository;

    @Override
    public List<CarShop> getShops() {
        return carShopRepository.findAll();
    }

    @Override
    public CarShop getShop(long id) {
        return carShopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid shop Id:" + id));
    }

    @Override
    public CarShop create(CarShop carShop) {
        return carShopRepository.save(carShop);
    }

    @Override
    public CarShop updateShop(long id, CarShop carShop) {
        carShop.setId(id);
        return carShopRepository.save(carShop);
    }

    @Override
    public void deleteShop(long id) {
        carShopRepository.deleteById(id);
    }

    @Override
    public List<CarShop> findAllByName(String name) {
        return carShopRepository.findAllByCarPreferences(name);
    }

    @Override
    public List<CarShop> findAllByCarPreferences(String carPreferences) {
        return carShopRepository.findAllByCarPreferences(carPreferences);
    }
}
