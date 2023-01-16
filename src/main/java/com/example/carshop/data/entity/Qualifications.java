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

    @ManyToMany
    @JoinColumn(name = "repairman_id")
    private Set<Repairman> repairman;

    @ManyToMany
    @JoinColumn(name = "repairdone_id")
    private Set<Repairdone> repairdone;

}
