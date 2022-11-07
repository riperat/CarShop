package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;

import java.util.List;

public class CarShopImpl implements CarShopService {

    @Override
    public List<Car> getShops() {
        return null;
    }

    @Override
    public Car getShop(long id) {
        return null;
    }

    @Override
    public Car create(CarShop carShop) {
        return null;
    }

    @Override
    public Car updateShop(long id, CarShop carShop) {
        return null;
    }

    @Override
    public void deleteShop(long id) {

    }

    @Override
    public List<Car> findAllByName(String brand) {
        return null;
    }

    @Override
    public List<Car> findAllByCarPreferences(String brand) {
        return null;
    }
}
