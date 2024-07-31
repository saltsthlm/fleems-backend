package com.lans.fleems.leg.model;

import com.lans.fleems.address.Address;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.driver.model.DriverInfoDto;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegInfoDto(
        UUID id,
        DriverInfoDto driver,
        Vehicle vehicle,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String startLocation,
        String endLocation,
        double distanceDriven,
        Address startAddress,
        Address endAddress
) {
}
