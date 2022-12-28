package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "qualifications")
public class Qualifications extends BaseEntity {

    String qualificationName;

    Long price;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Repairman> repairman;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qualifications")
    private List<Repairdone> rep;
}
