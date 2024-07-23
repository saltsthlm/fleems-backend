package com.lans.fleems.leg;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.task.CreateTaskDto;
import com.lans.fleems.task.Task;
import com.lans.fleems.task.TaskDto;
import com.lans.fleems.vehicle.Vehicle;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Leg {
    @Id
    @UuidGenerator
    private UUID id;
    private Driver driver;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String startLocation;
    private String endLocation;
    private Task task;

    public Leg(CreateLegDto createLegDto) {
        driver = createLegDto.driver();
        vehicle = createLegDto.vehicle();
        startTime = createLegDto.startTime();
        endTime = createLegDto.endTime();
        startLocation = createLegDto.startLocation();
        endLocation = createLegDto.endLocation();
        task = createLegDto.task();
    }

    public Leg(LegDto legDto) {
        id = legDto.id();
        driver = legDto.driver();
        vehicle = legDto.vehicle();
        startTime = legDto.startTime();
        endTime = legDto.endTime();
        startLocation = legDto.startLocation();
        endLocation = legDto.endLocation();
        task = legDto.task();
    }
}
