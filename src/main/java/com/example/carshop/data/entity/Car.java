package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<User> person;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Repairdone> repairsDone;
}
