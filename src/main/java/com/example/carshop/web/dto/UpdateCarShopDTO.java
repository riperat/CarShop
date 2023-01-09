package com.example.carshop.web.dto;

import com.example.carshop.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCarShopDTO {
    private String name;
    private String carPreferences;
}
