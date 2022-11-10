package com.example.carshop.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car extends BaseEntity{

    private String brand;

    private String model;

    private String color;

    private String registrationNumber;

    private int manufactureYear;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Person> people;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private List<Repairdone> repairsDone;
}
