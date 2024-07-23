package com.lans.fleems.leg;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.task.Task;
import com.lans.fleems.vehicle.Vehicle;

import java.time.LocalDateTime;

public record CreateLegDto(
        Driver driver,
        Vehicle vehicle,
        LocalDateTime startTime,
        String startLocation,
        Task task
) {
}
