package com.lans.fleems.leg.model;

import com.lans.fleems.address.Address;
import com.lans.fleems.address.CoordinateService;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.driver.model.DriverInfoDto;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

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
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String startLocation;

    @Column
    private String endLocation;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column
    @PositiveOrZero(message = "{invalid.distanceDriven}")
    private double distanceDriven;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JoinColumn(name = "startAddress_id")
    private Address startAddress;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JoinColumn(name = "endAddress_id")
    private Address endAddress;

    public Leg(CreateLegDto createLegDto, Task task, Driver driver, Vehicle vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
        startTime = createLegDto.startTime();
        startLocation = createLegDto.startLocation();
        this.task = task;
        this.startAddress = CoordinateService.coordinateStringToJsonString(startLocation);
        this.distanceDriven = 0;
    }

    public Leg(LegDto legDto) {
        id = legDto.id();
        endTime = legDto.endTime();
        endLocation = legDto.endLocation();
        distanceDriven = legDto.distanceDriven();
        this.endAddress = CoordinateService.coordinateStringToJsonString(endLocation);
    }

    public LegInfoDto toInfoDto() {
        return new LegInfoDto(id,
                DriverInfoDto.fromDriver(driver),
                vehicle,
                startTime,
                endTime,
                startLocation,
                endLocation,
                distanceDriven,
                startAddress,
                endAddress);
    }
}
