package com.lans.fleems.vehicle;

import java.util.UUID;

public record VehicleResponseDto(UUID id,
                                 String licenseNumber,
                                 double payload,
                                 double height,
                                 double weight,
                                 double length,
                                 String model) {
    public static VehicleResponseDto fromVehicle(Vehicle vehicle) {
        return new VehicleResponseDto(
                vehicle.getId(),
                vehicle.getLicenseNumber(),
                vehicle.getPayload(),
                vehicle.getHeight(),
                vehicle.getWeight(),
                vehicle.getLength(),
                vehicle.getModel()
                );
    }
}
