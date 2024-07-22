package com.lans.fleems.driver;

import com.lans.fleems.task.Task;
import com.lans.fleems.task.TaskResponseDto;

import java.util.UUID;

public record DriverResponseDto(UUID id) {
    public static DriverResponseDto fromDriver(Driver driver) {
        return new DriverResponseDto(driver.getId());
    }
}
