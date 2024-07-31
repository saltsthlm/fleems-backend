package com.lans.fleems.driver.model;

import java.util.UUID;

public record DriverInfoDto(UUID id,
                            String name,
                            String licenseNumber,
                            String phoneNumber,
                            String emailAddress) {
    public static DriverInfoDto fromDriver(Driver driver) {
        return new DriverInfoDto(
                driver.getId(),
                driver.getName(),
                driver.getLicenseNumber(),
                driver.getPhoneNumber(),
                driver.getEmailAddress()
        );
    }
}
