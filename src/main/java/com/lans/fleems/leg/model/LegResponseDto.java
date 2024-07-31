package com.lans.fleems.leg.model;

import com.lans.fleems.address.Address;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegResponseDto(
        UUID id,
        UUID driverId,
        UUID vehicleId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String startLocation,
        String endLocation,
        UUID taskId,
        double distanceDriven,
        Address startAddress,
        Address endAddress
) {
    public static LegResponseDto fromLeg(Leg leg) {
        return new LegResponseDto(
                leg.getId(),
                leg.getDriver().getId(),
                leg.getVehicle().getId(),
                leg.getStartTime(),
                leg.getEndTime(),
                leg.getStartLocation(),
                leg.getEndLocation(),
                leg.getTask().getId(),
                leg.getDistanceDriven(),
                leg.getStartAddress(),
                leg.getEndAddress()
        );
    }
}
