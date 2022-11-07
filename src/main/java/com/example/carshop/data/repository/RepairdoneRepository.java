package com.example.carshop.data.repository;

import com.example.carshop.data.entity.Person;
import com.example.carshop.data.entity.Repairdone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepairdoneRepository extends JpaRepository<Repairdone, Long> {
}
