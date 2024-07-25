package com.lans.fleems.assignments.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
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
