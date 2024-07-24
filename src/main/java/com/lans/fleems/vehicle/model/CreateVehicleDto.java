package com.lans.fleems.vehicle.model;

public record CreateVehicleDto(String licenseNumber,
                               double payload,
                               double height,
                               double weight,
                               double length,
                               double distanceDriven,
                               String model){
}
