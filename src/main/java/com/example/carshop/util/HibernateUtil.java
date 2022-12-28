package com.example.carshop.util;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.services.interfaces.QualificationsService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HibernateUtil {

    public static Set<String> getAllQualifications(List<Repairman> repairmen, QualificationsService qualificationsService) {
        final Set<String> qualificationNamesList = new HashSet<>();

        for (Repairman rep : repairmen) {
            final List<Qualifications> repairmanQS = qualificationsService.getQualificationByRepairman(rep);

            repairmanQS.forEach((RQ) -> qualificationNamesList.add(RQ.getQualificationName()));
        }
        return qualificationNamesList;
    }

}
