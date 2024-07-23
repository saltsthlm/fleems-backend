package com.lans.fleems.driver;

import java.util.UUID;

public record DriverDto(
        UUID id,
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAdress) {
}

