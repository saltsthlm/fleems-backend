package com.lans.fleems.vehicle;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.task.CreateTaskDto;
import com.lans.fleems.task.TaskDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Vehicle {
    @Id
    @UuidGenerator
    private UUID id;
    @Column(nullable = false)
    private String licenseNumber;
    @Column(nullable = false)
    private double payload;
    @Column(nullable = false)
    private double height;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private double length;
    @Column(nullable = false)
    private String model;

    public Vehicle(CreateVehicleDto createVehicleDto) {
    }

    public Vehicle(VehicleDto vehicleDto) {
        this.id = vehicleDto.id();
    }
}
