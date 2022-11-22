package com.example.carshop.util;

import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.RepairmanQ;
import com.example.carshop.services.interfaces.RepairmanQService;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtil {

    public static List<String> getAllQualifications(List<Repairman> repairmen, RepairmanQService repairmanQService) {
        final List<String> qualificationNamesList = new ArrayList<>();

        for (Repairman rep : repairmen) {
            final List<RepairmanQ> repairmanQS = repairmanQService.findAllByRepairman(rep);

            repairmanQS.forEach((RQ) -> qualificationNamesList.add(RQ.getQualifications().getQualificationName() + " "));
        }
        return qualificationNamesList;
    }

}
