package com.example.carshop.services.interfaces;

import com.example.carshop.data.entity.Qualifications;

import java.util.List;

public interface QualificationsService {

    List<Qualifications> getAllQualifications();

    Qualifications getQualification(long id);

    Qualifications create(Qualifications qualifications);

    Qualifications updateQualification(long id, Qualifications qualifications);

    void deleteQualification(long id);
}
