package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.sql.Date;

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


    //TODO change service type to Qualification no need for serviceType
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualificationID")
    private Qualifications qualification;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date reservationDate;
}
