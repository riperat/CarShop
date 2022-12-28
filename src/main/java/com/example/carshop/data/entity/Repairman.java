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
@Table(name = "repairman")
public class Repairman extends BaseEntity {

    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carShopID")
    private CarShop carShop;

    @ManyToMany(mappedBy = "repairman", fetch = FetchType.EAGER)
    private Set<Qualifications> qualifications;
}
