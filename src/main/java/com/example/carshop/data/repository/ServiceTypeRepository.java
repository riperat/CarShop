package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Person;
import com.example.carshop.data.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
}
