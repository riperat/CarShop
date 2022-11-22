package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Repairdone;

import java.util.List;

public interface RepairdoneService {

    Repairdone create(Repairdone repairdone);

    List<Repairdone> findAllByCar(Car car);

    Repairdone updateRepairdone(long id, Repairdone repairdone);

    List<Repairdone> findAllByCarShop(CarShop carShop);
}
