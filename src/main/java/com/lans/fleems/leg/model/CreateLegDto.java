package com.lans.fleems.leg.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;

public record CreateLegDto(
        Driver driver,
        Vehicle vehicle,
        LocalDateTime startTime,
        String startLocation,
        Task task
) {
}
