package com.example.carshop.web.view.model;

import com.example.carshop.data.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Set;

@Getter
@Setter
public class CreateCarShopViewModel {
    private String name;
    private String carPreferences;
}
