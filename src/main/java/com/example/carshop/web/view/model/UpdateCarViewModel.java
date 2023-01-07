package com.example.carshop.web.view.model;

import com.example.carshop.data.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateCarViewModel {
    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String color;

    @NotBlank
    private String registrationNumber;

    @NotNull
    @Min(value = 1950, message = "Min 1950")
    @Max(value = 2600, message = "Max 2100")
    private int manufactureYear;

    private Set<User> user;
}
