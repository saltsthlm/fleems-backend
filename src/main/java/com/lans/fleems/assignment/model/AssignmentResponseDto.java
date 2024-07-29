package com.lans.fleems.assignment.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.driver.model.DriverResponseDto;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.model.TaskResponseDto;
import com.lans.fleems.vehicle.model.Vehicle;
import com.lans.fleems.vehicle.model.VehicleResponseDto;

import java.util.UUID;

public record AssignmentResponseDto(
        UUID id,
        TaskResponseDto task,
        DriverResponseDto driver,
        VehicleResponseDto vehicle
) { public static AssignmentResponseDto fromAssignment(Assignment assignment) {
    return new AssignmentResponseDto(
            assignment.getId(),
            TaskResponseDto.fromTask(assignment.getTask()),
            DriverResponseDto.fromDriver(assignment.getDriver()),
            VehicleResponseDto.fromVehicle(assignment.getVehicle())
    );
} }
