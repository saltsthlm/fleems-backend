package com.lans.fleems.assignments.service;

import com.lans.fleems.assignments.model.Assignment;
import com.lans.fleems.assignments.repository.AssignmentRepository;
import com.lans.fleems.task.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

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
}
