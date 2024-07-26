package com.lans.fleems.assignment.model;

import java.util.UUID;

public record CreateAssignmentDto(
        UUID taskId,
        UUID driverId,
        UUID vehicleId
) {
}
