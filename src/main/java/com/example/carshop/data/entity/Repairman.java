package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "repairman")
public class Repairman extends BaseEntity {

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carShopID")
    private CarShop carShop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairman")
    private List<RepairmanQ> RepairmanQ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairman")
    private List<Repairdone> repairsDone;
}
