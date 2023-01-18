package com.example.carshop.util;

import com.example.carshop.data.entity.*;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;
import com.example.carshop.services.interfaces.QualificationsService;
import com.example.carshop.services.interfaces.RepairmanService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateUtil {

    public static Set<String> getAllShopsNames(CarShopService carShopService) {
        final Set<String> shopsNamesList = new HashSet<>();

        carShopService.getShops().forEach((qual) -> shopsNamesList.add(qual.getName()));

        return shopsNamesList;
    }

    public static Set<String> getAllQualificationNames(QualificationsService qualificationsService) {
        final Set<String> qualificationNamesList = new HashSet<>();

        qualificationsService.getAllQualifications().forEach((qual) -> qualificationNamesList.add(qual.getQualificationName()));

        return qualificationNamesList;
    }


    public static Set<String> getAllQualifications(List<Repairman> repairmen) {
        final Set<String> qualificationNamesList = new HashSet<>();

        for (Repairman rep : repairmen) {
            rep.getQualifications().forEach((qual) -> qualificationNamesList.add(qual.getQualificationName()));
        }
        return qualificationNamesList;
    }

    public static List<String> getAllCarsByPreference(User user, CarService carService, CarShopService carShopService, Long shopID) {
        List<String> myCars = new ArrayList<>();
        String carPreferences = carShopService.getShop(shopID).getCarPreferences();

        for (Car car :
                carService.getCarsByUser(user)) {

            if (car.getBrand().equals(carPreferences) || carPreferences == null) {
                myCars.add(car.getRegistrationNumber());
            }
        }

        return myCars;
    }

    public static List<String> getAllQualificationNamesByRepairdone(List<Repairdone> repairdoneList) {
        List<String> qualificationsListForRepair = new ArrayList<>();

        for (Repairdone repairdone :
                repairdoneList) {

            List<String> temp = new ArrayList<>();
            for (Qualifications qual :
                    repairdone.getQualifications()) {
                temp.add(qual.getQualificationName());
            }
            qualificationsListForRepair.add(String.join(", ", temp));
        }
        return qualificationsListForRepair;
    }
}
