package com.lans.fleems.vehicle.model;

import java.util.UUID;

public record VehicleDto (
        UUID id,
        String licenseNumber,
        double payload,
        double height,
        double weight,
        double length,
        String model
){ }
