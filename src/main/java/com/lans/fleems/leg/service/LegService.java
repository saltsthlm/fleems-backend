package com.lans.fleems.leg.service;

import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.repository.LegRepository;
import com.lans.fleems.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class LegService {
    private final LegRepository legRepository;

    public List<Leg> getAllLegsForVehicle(UUID vehicleId) {
        return legRepository.getAllLegs().stream().filter(e->e.getVehicle().getId().equals(vehicleId)).toList();
    }
    public List<Leg> getAllLegsForDriver(UUID driverId) {
        return legRepository.getAllLegs().stream().filter(e->e.getDriver().getId().equals(driverId)).toList();
    }

    public Leg finnishLeg(Leg leg) {
        Vehicle vehicle = leg.getVehicle();
        vehicle.setDistanceDriven(vehicle.getDistanceDriven()+leg.getDistanceDriven());
        leg.setVehicle(vehicle);
        return legRepository.updateLeg(leg);
    }
}
