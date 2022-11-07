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
@Table(name = "repairman")
public class Repairman extends BaseEntity {

    String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Qualifications> qualifications = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairman")
    private List<Repairdone> repairsDone;
}
