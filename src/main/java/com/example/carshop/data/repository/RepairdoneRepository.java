package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Person;
import com.example.carshop.data.entity.Repairdone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairdoneRepository extends JpaRepository<Repairdone, Long> {

    List<Repairdone> findAllByCar(Car car);

    List<Repairdone> findAllByCarShop(CarShop carShop);
}
