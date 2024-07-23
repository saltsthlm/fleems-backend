package com.lans.fleems.leg;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegInfoDto(
         UUID id,
         Driver driver,
         Vehicle vehicle,
         LocalDateTime startTime,
         LocalDateTime endTime,
         String startLocation,
         String endLocation,
         double distanceDriven
) {
}
