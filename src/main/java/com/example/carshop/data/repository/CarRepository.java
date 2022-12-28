package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByBrand(String brand);

    Car findByRegistrationNumber(String regNum);

    List<Car> findAllByUser(User user);
}
