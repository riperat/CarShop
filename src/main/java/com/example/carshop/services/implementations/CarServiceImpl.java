package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.User;
import com.example.carshop.data.repository.CarRepository;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.dto.UpdateCarDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

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
    public Car create(CreateCarDTO car) {
        return carRepository.save(modelMapper.map(car, Car.class));
    }

    @Override
    public Car updateCar(long id, UpdateCarDTO updateCarlDTO) {
        Car car = modelMapper.map(updateCarlDTO, Car.class);
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
    public Optional<Car> getCarById(long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getCarsByUser(User user) {
        return carRepository.findAllByUser(user);
    }
}
