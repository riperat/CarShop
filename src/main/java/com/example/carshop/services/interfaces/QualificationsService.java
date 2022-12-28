package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;

import java.util.List;

public interface QualificationsService {

    List<Qualifications> getAllQualifications();

    Qualifications getQualification(long id);

    Qualifications getQualificationByName(String qual);

    List<Qualifications> getQualificationByRepairman(Repairman repairman);

    Qualifications create(Qualifications qualifications);

    Qualifications updateQualification(long id, Qualifications qualifications);

    void deleteQualification(long id);
}
