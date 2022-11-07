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
@Table(name = "servicetype")
public class ServiceType extends BaseEntity {

    private String serviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carshopID")
    private CarShop carShop;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceType")
    private List<Repairdone> repairdones;
}
