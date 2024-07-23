package com.lans.fleems.vehicle;

import com.lans.fleems.driver.Driver;
import com.lans.fleems.task.CreateTaskDto;
import com.lans.fleems.task.TaskDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-Z]{3} \\d{2}[A-Z\\d]$\n", message="{invalid.licenseNumber}")
    private String licenseNumber;
    @Column(nullable = false)
    @Min(value = 0, message="{invalid.payload}")
    private double payload;
    @Column(nullable = false)
    @Min(value = 0, message="{invalid.height}")
    private double height;
    @Column(nullable = false)
    @Min(value = 0, message="{invalid.weight}")
    private double weight;
    @Column(nullable = false)
    @Min(value = 0, message="{invalid.length}")
    private double length;
    @Column(nullable = false)
    private String model;

    public Vehicle(CreateVehicleDto createVehicleDto) {
        this.licenseNumber = createVehicleDto.licenseNumber();
        this.payload = createVehicleDto.payload();
        this.height = createVehicleDto.height();
        this.weight = createVehicleDto.weight();
        this.length = createVehicleDto.length();
        this.model = createVehicleDto.model();
    }

    public Vehicle(VehicleDto vehicleDto) {
        this.id = vehicleDto.id();
        this.licenseNumber = vehicleDto.licenseNumber();
        this.payload = vehicleDto.payload();
        this.height = vehicleDto.height();
        this.weight = vehicleDto.weight();
        this.length = vehicleDto.length();
        this.model = vehicleDto.model();
    }
}
