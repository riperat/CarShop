package com.example.carshop.data.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String color;

    @NotBlank
    private String registrationNumber;

    @NotNull
    @Min(value = 1950, message = "Min 1950")
    private int manufactureYear;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Repairdone> repairsDone;
}
