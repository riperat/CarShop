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
@Table(name = "carshop")
public class CarShop extends BaseEntity {

    private String name;

    private String carPreferences;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carShop")
    private List<Repairdone> repairsDone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carShop")
    private List<Repairman> repairmen;
}
