package com.apap.tu04.service;

import com.apap.tu04.model.FlightModel;

import java.util.List;

public interface FlightService {
    void addFlight (FlightModel flight);
    List<FlightModel> findAllFlightByPilotLicenseNumber(String licenseNumber);
    FlightModel findById (Long id);
    void deleteFlight(Long id);
    FlightModel updateFlight(FlightModel flightModel);
    List<FlightModel> flightList();
}
