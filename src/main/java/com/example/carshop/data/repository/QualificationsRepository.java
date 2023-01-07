package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualificationsRepository extends JpaRepository<Qualifications, Long> {

    Qualifications findByQualificationName(String qual);

    List<Qualifications> findAllByRepairman(Repairman repairman);
}
