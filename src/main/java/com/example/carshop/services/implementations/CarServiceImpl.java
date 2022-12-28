package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.User;
import com.example.carshop.data.repository.CarRepository;
import com.example.carshop.data.repository.UserRepository;
import com.example.carshop.services.interfaces.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid car Id:" + id));
    }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(long id, Car car) {
        car.setId(id);
        return carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> getCarsByBrand(String brand) {
        return carRepository.findAllByBrand(brand);
    }

    @Override
    public Car getCarByPlate(String plate) {
        return carRepository.findByRegistrationNumber(plate);
    }

    @Override
    public List<Car> getCarsByUser(User user) {
        return carRepository.findAllByUser(user);
    }
}
