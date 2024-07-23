package com.lans.fleems.vehicle;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.getAllVehicles();
    }

    public Vehicle getVehicleById(UUID vehicleId) {
        return vehicleRepository.getVehicleById(vehicleId);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.createVehicle(vehicle);
    }

    public void deleteVehicleById(UUID vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.updateVehicle(vehicle);
    }
}
