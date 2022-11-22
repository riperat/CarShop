package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.repository.QualificationsRepository;
import com.example.carshop.services.interfaces.QualificationsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QualificationsImpl implements QualificationsService {

    private final QualificationsRepository qualificationsRepository;

    @Override
    public List<Qualifications> getAllQualifications() {
        return qualificationsRepository.findAll();
    }

    @Override
    public Qualifications getQualification(long id) {
        return qualificationsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid qualification Id:" + id));
    }

    @Override
    public Qualifications create(Qualifications qualifications) {
        return qualificationsRepository.save(qualifications);
    }

    @Override
    public Qualifications updateQualification(long id, Qualifications qualifications) {
        return qualificationsRepository.save(qualifications);
    }

    @Override
    public void deleteQualification(long id) {
        qualificationsRepository.deleteById(id);
    }
}
