package com.lans.fleems.assignmentconnections.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.model.TaskResponseDto;
import com.lans.fleems.vehicle.model.Vehicle;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.UUID;

public record AssignmentResponseDto(
        UUID id,
        Task task,
        Driver driver,
        Vehicle vehicle
) { public static AssignmentResponseDto fromAssignment(Assignment assignment) {
    return new AssignmentResponseDto(
            assignment.getId(),
            assignment.getTask(),
            assignment.getDriver(),
            assignment.getVehicle()
    );
} }
