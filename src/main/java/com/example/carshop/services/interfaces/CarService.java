package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.User;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.dto.UpdateCarDTO;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getCars();

    Car getCar(long id);

    Car create(CreateCarDTO car);

    Car updateCar(long id, UpdateCarDTO updateCarlDTO);

    void deleteCar(long id);

    List<Car> getCarsByBrand(String brand);

    Car getCarByPlate(String plate);

    Optional<Car> getCarById(long id);

    List<Car> getCarsByUser(User user);
}
