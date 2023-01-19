package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Car;
import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.repository.QualificationsRepository;
import com.example.carshop.services.interfaces.QualificationsService;
import com.example.carshop.web.dto.CreateQualDTO;
import com.example.carshop.web.dto.UpdateQualDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QualificationsImpl implements QualificationsService {
    private final ModelMapper modelMapper;
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
    public Qualifications getQualificationByName(String qual) {
        return qualificationsRepository.findByQualificationName(qual);
    }

    @Override
    public List<Qualifications> getQualificationByRepairman(Repairman repairman) {
        return qualificationsRepository.findAllByRepairman(repairman);
    }

    @Override
    public Qualifications create(CreateQualDTO qualifications) {
        return qualificationsRepository.save(modelMapper.map(qualifications, Qualifications.class));
    }

    @Override
    public Qualifications updateQualification(long id, UpdateQualDTO qualifications) {
        Qualifications qual = modelMapper.map(qualifications, Qualifications.class);
        qual.setId(id);
        return qualificationsRepository.save(qual);
    }

    @Override
    public void deleteQualification(long id) {
        qualificationsRepository.deleteById(id);
    }
}
