package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByBrand(String brand);
}
