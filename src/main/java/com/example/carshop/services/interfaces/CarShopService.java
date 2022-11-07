package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.CarShop;

import java.util.List;

public interface CarShopService {
    List<Car> getShops();

    Car getShop(long id);

    Car create(CarShop carShop);

    Car updateShop(long id, CarShop carShop);

    void deleteShop(long id);

    List<Car> findAllByName(String brand);

    List<Car> findAllByCarPreferences(String brand);
}
