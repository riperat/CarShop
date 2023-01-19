package com.example.carshop.web.view.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateQualViewModel {
    @NotBlank
    String qualificationName;

    @NotNull
    @Min(value = 0, message = "Minimum value is 0")
    @Max(value = 100000, message = "You corrupt pig, just make him buy a new car")
    Long price;
}
