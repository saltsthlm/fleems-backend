package com.lans.fleems.leg;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
    @JoinColumn(name ="driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name ="vehicle_id")
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

    @ManyToOne
    @JoinColumn(name ="task_id")
    private Task task;

    @Column
    @Min(value = 0, message="{invalid.distanceDriven}")
    private double distanceDriven;

    public Leg(CreateLegDto createLegDto) {
        driver = createLegDto.driver();
        vehicle = createLegDto.vehicle();
        startTime = createLegDto.startTime();
        startLocation = createLegDto.startLocation();
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
        distanceDriven =legDto.distanceDriven();

    }
    public LegInfoDto toInfoDto() {
       return new LegInfoDto( id,
                driver,
                vehicle,
                startTime,
                endTime,
                startLocation,
                endLocation,
               distanceDriven) ;
    }
}
