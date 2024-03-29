package com.example.carshop.data.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "qualifications")
public class Qualifications extends BaseEntity {

    @NotBlank
    String qualificationName;

    @NotNull
    @Min(value = 0, message = "Minimum value is 0")
    @Max(value = 100000, message = "You corrupt pig, just make him buy a new car")
    Long price;

    @ManyToMany
    @JoinColumn(name = "repairman_id")
    private Set<Repairman> repairman;

    @ManyToMany
    @JoinColumn(name = "repairdone_id")
    private Set<Repairdone> repairdone;

}
