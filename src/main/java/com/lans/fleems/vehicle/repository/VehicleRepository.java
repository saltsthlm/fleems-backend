package com.lans.fleems.vehicle.repository;


import com.lans.fleems.error.exception.NoSuchVehicleException;
import com.lans.fleems.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class VehicleRepository {

    private final IVehicleRepository iVehicleRepository;

    public List<Vehicle> getAllVehicles() {
        return iVehicleRepository.findAll();
    }

    public Vehicle getVehicleById(UUID vehicleId) {
        return iVehicleRepository.findById(vehicleId)
                .orElseThrow(NoSuchVehicleException::new);
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return iVehicleRepository.save(vehicle);
    }

    public void deleteById(UUID vehicleId) {
        if (!iVehicleRepository.existsById(vehicleId)) {
            throw new NoSuchVehicleException();
        }
        iVehicleRepository.deleteById(vehicleId);
    }

    public Vehicle updateVehicle(Vehicle vehicle) {
        if (!iVehicleRepository.existsById(vehicle.getId())) {
            throw new NoSuchVehicleException();
        }
        return iVehicleRepository.save(vehicle);
    }
}
