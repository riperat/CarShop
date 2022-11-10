package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Repairdone;
import com.example.carshop.data.repository.CarRepository;
import com.example.carshop.data.repository.RepairdoneRepository;
import com.example.carshop.services.interfaces.RepairdoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RepairdoneServiceImpl implements RepairdoneService {

    private final RepairdoneRepository repairdoneRepository;

    @Override
    public Repairdone create(Repairdone repairdone) {
        return repairdoneRepository.save(repairdone);
    }

    @Override
    public List<Repairdone> findAllByCar(Car car) {
        return repairdoneRepository.findAllByCar(car);
    }

    @Override
    public List<Repairdone> findAllByCarShop(CarShop carShop) {
        return repairdoneRepository.findAllByCarShop(carShop);
    }
}
