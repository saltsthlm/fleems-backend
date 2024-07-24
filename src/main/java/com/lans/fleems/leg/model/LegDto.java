package com.lans.fleems.leg.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegDto(
        UUID id,
        Driver driver,
        Vehicle vehicle,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String startLocation,
        String endLocation,
        Task task,
        double distanceDriven
) {}
