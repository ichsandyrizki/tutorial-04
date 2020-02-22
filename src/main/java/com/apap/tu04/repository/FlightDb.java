package com.apap.tu04.repository;

import com.apap.tu04.model.FlightModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDb extends JpaRepository<FlightModel, Long> {

}

