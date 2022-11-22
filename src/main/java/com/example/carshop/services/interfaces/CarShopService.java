package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.CarShop;

import java.util.List;

public interface CarShopService {
    List<CarShop> getShops();

    CarShop getShop(long id);

    CarShop create(CarShop carShop);

    CarShop updateShop(long id, CarShop carShop);

    void deleteShop(long id);

    List<CarShop> findAllByName(String name);

    List<CarShop> findAllByCarPreferences(String carPreferences);
}
