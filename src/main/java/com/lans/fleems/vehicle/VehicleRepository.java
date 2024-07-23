package com.lans.fleems.vehicle;


import com.lans.fleems.error.NoSuchClientException;
import com.lans.fleems.error.NoSuchTaskException;
import com.lans.fleems.error.NoSuchVehicleException;
import com.lans.fleems.task.ITaskRepository;
import com.lans.fleems.task.Task;
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
