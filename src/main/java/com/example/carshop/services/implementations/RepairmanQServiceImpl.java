package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.RepairmanQ;
import com.example.carshop.data.repository.RepairdoneRepository;
import com.example.carshop.data.repository.RepairmanQRepository;
import com.example.carshop.services.interfaces.RepairdoneService;
import com.example.carshop.services.interfaces.RepairmanQService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RepairmanQServiceImpl implements RepairmanQService {

    private final RepairmanQRepository repairmanQRepository;

    @Override
    public RepairmanQ create(RepairmanQ repairmanQ) {
        return repairmanQRepository.save(repairmanQ);
    }

    @Override
    public List<RepairmanQ> findAllByQualifications(Qualifications qualifications) {
        return repairmanQRepository.findAllByQualifications(qualifications);
    }

    @Override
    public List<RepairmanQ> findAllByRepairman(Repairman repairman) {
        return repairmanQRepository.findAllByRepairman(repairman);
    }
}
