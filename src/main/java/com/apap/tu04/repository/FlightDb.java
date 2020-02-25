package com.apap.tu04.repository;

import com.apap.tu04.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FlightDb extends JpaRepository<FlightModel, Long> {
    List<FlightModel> findByPilotLicenseNumber(String licenseNumber);
    List<FlightModel> removeById (Long id);
    Optional<FlightModel> findById(Long id);
    List<FlightModel> findAll();
}

