package com.lans.fleems.leg.model;

import com.lans.fleems.address.Address;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegDto(
        UUID id,
        LocalDateTime endTime,
        String endLocation,
        double distanceDriven
) {
}
