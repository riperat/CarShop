package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "repairman")
public class Repairman extends BaseEntity {

    @NotBlank
    String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carShopID")
    private CarShop carShop;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "qualification_id")
    private Set<Qualifications> qualifications;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "repairman")
    private List<User> user;
}
