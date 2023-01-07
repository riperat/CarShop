package com.example.carshop.web.dto;

import com.example.carshop.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCarDTO {
    private String brand;
    private String model;
    private String color;
    private String registrationNumber;
    private int manufactureYear;
    private Set<User> user;
}
