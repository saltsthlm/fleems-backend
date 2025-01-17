package com.lans.fleems.vehicle.model;

import java.util.UUID;

public record VehicleResponseDto(UUID id,
                                 String licenseNumber,
                                 double payload,
                                 double height,
                                 double weight,
                                 double length,
                                 double distanceDriven,
                                 String model) {
    public static VehicleResponseDto fromVehicle(Vehicle vehicle) {
        return new VehicleResponseDto(
                vehicle.getId(),
                vehicle.getLicenseNumber(),
                vehicle.getPayload(),
                vehicle.getHeight(),
                vehicle.getWeight(),
                vehicle.getLength(),
                vehicle.getDistanceDriven(),
                vehicle.getModel()
                );
    }
}
