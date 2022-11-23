package com.example.carshop.util;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.RepairmanQ;
import com.example.carshop.services.interfaces.CarService;
import com.example.carshop.services.interfaces.CarShopService;
import com.example.carshop.services.interfaces.RepairmanQService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.carshop.util.TextUtil.isNullorEmpty;

public class HibernateUtil {

    public static Set<String> getAllQualifications(List<Repairman> repairmen, RepairmanQService repairmanQService) {
        final Set<String> qualificationNamesList = new HashSet<>();

        for (Repairman rep : repairmen) {
            final List<RepairmanQ> repairmanQS = repairmanQService.findAllByRepairman(rep);

            repairmanQS.forEach((RQ) -> qualificationNamesList.add(RQ.getQualifications().getQualificationName()));
        }
        return qualificationNamesList;
    }

}
