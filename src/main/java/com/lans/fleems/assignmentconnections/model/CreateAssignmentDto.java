package com.lans.fleems.assignmentconnections.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;

public record CreateAssignmentDto(
        Task task,
        Driver driver,
        Vehicle vehicle
) {
}
