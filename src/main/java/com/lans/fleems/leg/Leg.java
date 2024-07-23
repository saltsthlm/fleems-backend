package com.lans.fleems.leg;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.task.Task;
import com.lans.fleems.vehicle.Vehicle;
import jakarta.persistence.*;
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
    @ManyToOne
    @JoinColumn(name ="driver_id")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name ="vehicle_id")
    private Vehicle vehicle;
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;
    @Column(name = "start_location", nullable = false)
    private String startLocation;
    @Column(name = "end_location", nullable = false)
    private String endLocation;
    @ManyToOne
    @JoinColumn(name ="task_id")
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
