package com.lans.fleems.vehicle.service;

import com.lans.fleems.assignment.repository.AssignmentRepository;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;
import com.lans.fleems.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final AssignmentRepository assignmentRepository;

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

    public List<Vehicle> getAssignableVehicles(Task task) {
        LocalDateTime startDate =task.getStartDate();
        LocalDateTime endDate = startDate.plusDays(task.getExpectedTime());
        HashMap<UUID, Vehicle> vehicles = new HashMap<>();
        vehicleRepository.getAllVehicles().forEach(vehicle -> vehicles.put(vehicle.getId(),vehicle));
        assignmentRepository.getAllAssignments()
                .stream()
                .filter(e-> e.getTask()
                        .getStartDate()
                        .isBefore(endDate)&&e.getTask()
                        .getStartDate()
                        .isAfter(startDate)||
                        e.getTask()
                                .getStartDate()
                                .plusDays(e.getTask().getExpectedTime())
                                .isBefore(endDate)
                                && e.getTask()
                                .getStartDate()
                                .plusDays(e.getTask().getExpectedTime())
                                .isAfter(startDate))
                .forEach(e->vehicles.remove(e.getVehicle().getId()));
        return vehicles.values().stream().toList();
    }
}
