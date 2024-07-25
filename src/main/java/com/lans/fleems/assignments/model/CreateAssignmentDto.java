package com.lans.fleems.assignments.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

import java.time.LocalDateTime;

public record CreateAssignmentDto(
        Task task,
        Driver driver,
        Vehicle vehicle
) {
}