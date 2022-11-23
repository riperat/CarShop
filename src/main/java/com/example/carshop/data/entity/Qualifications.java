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
@Table(name = "qualifications")
public class Qualifications extends BaseEntity {

    String qualificationName;

    Long price;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairman")
    private List<RepairmanQ> RepairmanQ;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qualifications")
    private List<Repairdone> rep;
}
