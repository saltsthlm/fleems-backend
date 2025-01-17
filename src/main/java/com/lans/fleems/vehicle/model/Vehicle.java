package com.lans.fleems.vehicle.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
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

    @Column(unique=true)
    @Pattern(regexp = "^[A-Z]{3}\\s?\\d{2}[A-Z\\d]$", message="{invalid.licenseNumber}")
    private String licenseNumber;

    @Column(nullable = false)
    @PositiveOrZero(message="{invalid.payload}")
    private double payload;

    @Column(nullable = false)
    @PositiveOrZero(message="{invalid.height}")
    private double height;

    @Column(nullable = false)
    @PositiveOrZero(message="{invalid.weight}")
    private double weight;

    @Column(nullable = false)
    @PositiveOrZero(message="{invalid.length}")
    private double length;

    @Column(nullable = false)
    @PositiveOrZero(message="{invalid.length}")
    private double distanceDriven;

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
