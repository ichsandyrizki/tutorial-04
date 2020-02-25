package com.apap.tu04.repository;

import com.apap.tu04.model.PilotModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PilotDb extends JpaRepository<PilotModel, Long> {
    PilotModel findByLicenseNumber(String licenseNumber);
    Optional<PilotModel> findById(Long id);
    List<PilotModel> removeById(Long id);
    List<PilotModel> findAll();
}
