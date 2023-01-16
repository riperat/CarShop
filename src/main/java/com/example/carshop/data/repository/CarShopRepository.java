package com.example.carshop.data.repository;

import com.example.carshop.data.entity.CarShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarShopRepository extends JpaRepository<CarShop, Long> {
    CarShop findByName(String name);

    List<CarShop> findAllByCarPreferences(String carPreferences);
}
