package com.lans.fleems.assignments.service;

import com.lans.fleems.assignments.model.Assignment;
import com.lans.fleems.assignments.repository.AssignmentRepository;
import com.lans.fleems.driver.repository.DriverRepository;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.repository.TaskRepository;
import com.lans.fleems.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.createAssignment(assignment);
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
}
