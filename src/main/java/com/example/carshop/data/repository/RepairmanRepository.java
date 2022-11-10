package com.example.carshop.data.repository;

import com.example.carshop.data.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairmanRepository extends JpaRepository<Repairman, Long> {

    List<Repairman> findAllByCarShop(CarShop carShop);
}
