package com.lans.fleems.vehicle;

public record CreateVehicleDto(String licenseNumber,
                               double payload,
                               double height,
                               double weight,
                               double length,
                               String model){
}
