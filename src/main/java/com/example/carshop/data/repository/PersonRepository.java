package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
