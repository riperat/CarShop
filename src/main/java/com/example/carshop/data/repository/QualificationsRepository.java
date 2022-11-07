package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Person;
import com.example.carshop.data.entity.Qualifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QualificationsRepository extends JpaRepository<Qualifications, Long> {
}
