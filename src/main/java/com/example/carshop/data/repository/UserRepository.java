/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.carshop.data.repository;

import com.example.carshop.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Kostadinova
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
