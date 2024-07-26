package com.lans.fleems.driver.model;

import java.util.UUID;

public record DriverDto(
        UUID id,
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAddress,
        String photo) {
}

