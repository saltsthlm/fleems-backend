package com.lans.fleems.leg;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.task.Task;
import com.lans.fleems.vehicle.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

public record LegInfoDto(
         UUID id,
         Driver driver,
         Vehicle vehicle,
         LocalDateTime startTime,
         LocalDateTime endTime,
         String startLocation,
         String endLocation,
         double distanceDriven
) {
}
