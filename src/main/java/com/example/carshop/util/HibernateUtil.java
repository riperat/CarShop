package com.example.carshop.util;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.User;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;
import com.example.carshop.services.interfaces.QualificationsService;

import java.util.*;

public class HibernateUtil {

    public static Set<String> getAllQualifications(List<Repairman> repairmen, QualificationsService qualificationsService) {
        final Set<String> qualificationNamesList = new HashSet<>();

        for (Repairman rep : repairmen) {
            final List<Qualifications> repairmanQS = qualificationsService.getQualificationByRepairman(rep);

            repairmanQS.forEach((RQ) -> qualificationNamesList.add(RQ.getQualificationName()));
        }
        return qualificationNamesList;
    }

    public static List<String> getAllCarsByPreference(User user, CarService carService, CarShopService carShopService, Long shopID) {
        List<String> myCars = new ArrayList<>();
        String carPreferences = carShopService.getShop(shopID).getCarPreferences();

        for (Car car :
                carService.getCarsByUser(user)) {

            if (car.getBrand().toLowerCase(Locale.ROOT).equals(carPreferences) || carPreferences == null) {
                myCars.add(car.getRegistrationNumber());
            }
        }

        return myCars;
    }
}
