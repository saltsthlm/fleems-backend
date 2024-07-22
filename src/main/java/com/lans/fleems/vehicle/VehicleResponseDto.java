package com.lans.fleems.vehicle;

import com.lans.fleems.task.Task;
import com.lans.fleems.task.TaskResponseDto;

import java.util.UUID;

public record VehicleResponseDto(UUID id) {
    public static VehicleResponseDto fromVehicle(Vehicle vehicle) {
        return new VehicleResponseDto(vehicle.getId());
    }
}
