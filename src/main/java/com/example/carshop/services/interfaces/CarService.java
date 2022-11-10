package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getCars();

    Car getCar(long id);

    Car create(Car car);

    Car updateCar(long id, Car car);

    void deleteCar(long id);

    List<Car> getCarsByBrand(String brand);
}
