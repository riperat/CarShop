package com.example.carshop.web.dto;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Qualifications;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateQualDTO {
    String qualificationName;
    Long price;
}
