package com.lans.fleems.leg.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateLegDto(
        UUID driverId,
        UUID vehicleId,
        LocalDateTime startTime,
        String startLocation,
        UUID taskId
) {
}
