package com.example.carshop.util;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.repository.CarRepository;
import com.example.carshop.web.dto.CreateCarDTO;
import com.example.carshop.web.view.model.CreateCarViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Service
public class UniqueRegistrationNumberValidator implements Validator {

    @Autowired
    private CarRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Car.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateCarDTO entity = (CreateCarDTO) target;
        if (repository.existsByRegistrationNumber(entity.getRegistrationNumber())) {
            errors.rejectValue("registrationNumber", "registrationNumber.duplicate", "Registration Number already exists.");
        }
    }

}
