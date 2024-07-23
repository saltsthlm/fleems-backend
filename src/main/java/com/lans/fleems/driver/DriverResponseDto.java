package com.lans.fleems.driver;

import com.lans.fleems.task.Task;
import com.lans.fleems.task.TaskResponseDto;

import java.util.UUID;

public record DriverResponseDto(
        UUID id,
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAdress) {
    public static DriverResponseDto fromDriver(Driver driver) {
        return new DriverResponseDto(
                driver.getId(),
                driver.getName(),
                driver.getLicenseNumber(),
                driver.getPhoneNumber(),
                driver.getEmailAdress()
        );
    }
}
