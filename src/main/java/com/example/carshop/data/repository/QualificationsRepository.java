package com.example.carshop.data.repository;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Person;
import com.example.carshop.data.entity.Qualifications;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualificationsRepository extends JpaRepository<Qualifications, Long> {
}
