package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.RepairmanQ;

import java.util.List;

public interface RepairmanQService {

    RepairmanQ create(RepairmanQ repairmanQ);

    List<RepairmanQ> findAllByQualifications(Qualifications qualifications);

    List<RepairmanQ> findAllByRepairman(Repairman repairman);
}
