package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "repairmanQ")
public class RepairmanQ extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qualificationsID")
    private Qualifications qualifications;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repairmanID")
    private Repairman repairman;
}
