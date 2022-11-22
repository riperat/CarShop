package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.RepairmanQ;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairmanQRepository extends JpaRepository<RepairmanQ, Long> {

    List<RepairmanQ> findAllByQualifications(Qualifications qualifications);

    List<RepairmanQ> findAllByRepairman(Repairman repairman);
}
