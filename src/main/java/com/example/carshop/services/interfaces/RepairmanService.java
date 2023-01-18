package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.web.dto.CreateRepairmanDTO;
import com.example.carshop.web.dto.UpdateRepairmanDTO;

import java.util.List;

public interface RepairmanService {

    List<Repairman> getAllRepairmen();

    Repairman getRepairman(long id);

    Repairman create(Repairman repairman);

    Repairman updateRepairman(long id, UpdateRepairmanDTO repairman);

    void deleteRepairman(long id);

    List<Repairman> findAllByCarShop(CarShop carShop);
}
