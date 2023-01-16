package com.example.carshop.services.implementations;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Qualifications;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.repository.RepairmanRepository;
import com.example.carshop.services.interfaces.RepairmanService;
import com.example.carshop.web.dto.CreateRepairmanDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RepairmanServiceImpl implements RepairmanService {

    private final RepairmanRepository repairmanRepository;


    @Override
    public List<Repairman> getAllRepairmen() {
        return repairmanRepository.findAll();
    }

    @Override
    public Repairman getRepairman(long id) {
        return repairmanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid repairman Id:" + id));
    }

    @Override
    public Repairman create(Repairman repairman) {
        return repairmanRepository.save(repairman);
    }

    @Override
    public Repairman updateRepairman(long id, Repairman repairman) {
        repairman.setId(id);
        return repairmanRepository.save(repairman);
    }

    @Override
    public void deleteRepairman(long id) {
        repairmanRepository.deleteById(id);
    }

    @Override
    public List<Repairman> findAllByCarShop(CarShop carShop) {
        return repairmanRepository.findAllByCarShop(carShop);
    }
}
