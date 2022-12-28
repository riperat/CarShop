package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    private String brand;

    private String model;

    private String color;

    private String registrationNumber;

    private int manufactureYear;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Repairdone> repairsDone;
}
