package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Person;
import com.example.carshop.data.entity.Repairman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairmanRepository extends JpaRepository<Repairman, Long> {
}
