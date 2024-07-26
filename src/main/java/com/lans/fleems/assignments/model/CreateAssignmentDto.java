package com.lans.fleems.assignments.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateAssignmentDto(
        UUID taskId,
        UUID driverId,
        UUID vehicleId
) {
}
