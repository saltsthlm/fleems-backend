package com.lans.fleems.assignment.service;

import com.lans.fleems.assignment.model.Assignment;
import com.lans.fleems.assignment.repository.AssignmentRepository;
import com.lans.fleems.driver.repository.DriverRepository;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.repository.TaskRepository;
import com.lans.fleems.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverRepository driverRepository;
    private final TaskRepository taskRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.getAllAssignments();
    }


    public List<Task> getTasksForDriver(UUID driverId) {
        return assignmentRepository.getAllAssignments()
                .stream()
                .filter(e->e.getDriver().getId()==driverId)
                .map(Assignment::getTask)
                .toList();
    }
    public List<Task> getTasksForVehicle(UUID vehicleId) {
        return assignmentRepository.getAllAssignments()
                .stream()
                .filter(e->e.getVehicle().getId()==vehicleId)
                .map(Assignment::getTask)
                .toList();
    }

    public Assignment createAssignment(UUID driverId, UUID vehicleId, UUID taskId) {
        return assignmentRepository.createAssignment(
                new Assignment(
                        taskRepository.getTaskById(taskId),
                        driverRepository.getDriverById(driverId),
                        vehicleRepository.getVehicleById(vehicleId)));

    }

    public List<Assignment> getAllActiveAssignments() {
        return assignmentRepository.getAllAssignments()
                .stream()
                .filter(e-> !Objects.equals(e.getTask().getLegs().getLast().getEndLocation(), e.getTask().getEndDestination()))
                .toList();
    }
}
