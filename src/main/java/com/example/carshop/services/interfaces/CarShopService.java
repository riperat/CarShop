package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.web.dto.CreateCarShopDTO;
import com.example.carshop.web.dto.UpdateCarShopDTO;

import java.util.List;

public interface CarShopService {
    List<CarShop> getShops();

    CarShop getShop(long id);

    CarShop create(CreateCarShopDTO createCarShopDTO);

    CarShop updateShop(long id, UpdateCarShopDTO updateCarShopDTO);

    void deleteShop(long id);

    List<CarShop> findAllByName(String name);

    List<CarShop> findAllByCarPreferences(String carPreferences);
}
