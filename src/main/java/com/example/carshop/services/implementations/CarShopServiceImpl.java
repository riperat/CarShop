package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.repository.CarShopRepository;
import com.example.carshop.services.interfaces.CarShopService;
import com.example.carshop.web.dto.CreateCarShopDTO;
import com.example.carshop.web.dto.UpdateCarShopDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarShopServiceImpl implements CarShopService {
    private final CarShopRepository carShopRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CarShop> getShops() {
        return carShopRepository.findAll();
    }

    @Override
    public CarShop getShop(long id) {
        return carShopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid shop Id:" + id));
    }

    @Override
    public CarShop create(CreateCarShopDTO carShop) {
        return carShopRepository.save(modelMapper.map(carShop, CarShop.class));
    }

    @Override
    public CarShop updateShop(long id, UpdateCarShopDTO updateCarShopDTO) {
        CarShop carShop = modelMapper.map(updateCarShopDTO, CarShop.class);
        carShop.setId(id);
        return carShopRepository.save(carShop);
    }

    @Override
    public void deleteShop(long id) {
        carShopRepository.deleteById(id);
    }

    @Override
    public List<CarShop> findAllByName(String name) {
        return carShopRepository.findAllByCarPreferences(name);
    }

    @Override
    public List<CarShop> findAllByCarPreferences(String carPreferences) {
        return carShopRepository.findAllByCarPreferences(carPreferences);
    }
}
