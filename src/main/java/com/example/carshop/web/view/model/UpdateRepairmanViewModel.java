package com.example.carshop.web.view.model;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Qualifications;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UpdateRepairmanViewModel {
    private String name;
    private CarShop carShop;
    private Set<Qualifications> qualifications;
}
