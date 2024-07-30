package com.lans.fleems.leg.model;

import com.lans.fleems.address.Address;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegResponseDto(
        UUID id,
        Driver driver,
        Vehicle vehicle,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String startLocation,
        String endLocation,
        Task task,
        double distanceDriven,
        Address startAddress,
        Address endAddress
) {
    public static LegResponseDto fromLeg(Leg leg) {
        return new LegResponseDto(
                leg.getId(),
                leg.getDriver(),
                leg.getVehicle(),
                leg.getStartTime(),
                leg.getEndTime(),
                leg.getStartLocation(),
                leg.getEndLocation(),
                leg.getTask(),
                leg.getDistanceDriven(),
                leg.getStartAddress(),
                leg.getEndAddress()
        );
    }
}
