package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "repairdone")
public class Repairdone extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carshopID")
    private CarShop carShop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carID")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicetypeID")
    private ServiceType serviceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reparmanID")
    private Repairman repairman;

    private java.sql.Date dateStarted;

    private java.sql.Date dateDone;
}
