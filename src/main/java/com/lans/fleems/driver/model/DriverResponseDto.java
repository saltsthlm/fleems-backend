package com.lans.fleems.driver.model;


import com.lans.fleems.driver.service.DriverService;

import java.util.UUID;

public record DriverResponseDto(
        UUID id,
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAddress,
        String photo) {
    public static DriverResponseDto fromDriver(Driver driver) {
        return new DriverResponseDto(
                driver.getId(),
                driver.getName(),
                driver.getLicenseNumber(),
                driver.getPhoneNumber(),
                driver.getEmailAddress(),
                DriverService.byteArrayToPhotoString(driver.getPhoto())
        );
    }
}
