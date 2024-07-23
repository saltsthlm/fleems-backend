package com.lans.fleems.vehicle.controller;

import com.lans.fleems.vehicle.service.VehicleService;
import com.lans.fleems.vehicle.model.CreateVehicleDto;
import com.lans.fleems.vehicle.model.Vehicle;
import com.lans.fleems.vehicle.model.VehicleDto;
import com.lans.fleems.vehicle.model.VehicleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("${api.base-path}${api.controllers.vehicles}")
public class VehicleController {

    private final VehicleService vehicleService;

    @Value("${api.base-path}${api.controllers.vehicles}/")
    public static String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles.stream().map(VehicleResponseDto::fromVehicle).toList());
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleResponseDto> getVehicleById(@PathVariable UUID vehicleId) {
        Vehicle vehicle = vehicleService.getVehicleById(vehicleId);
        return ResponseEntity.ok(VehicleResponseDto.fromVehicle(vehicle));
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<Void> deleteVehicleById(@PathVariable UUID vehicleId) {
        vehicleService.deleteVehicleById(vehicleId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<VehicleResponseDto> updateVehicle(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleService.updateVehicle(new Vehicle(vehicleDto));
        return ResponseEntity.ok(VehicleResponseDto.fromVehicle(vehicle));
    }

    @PostMapping
    public ResponseEntity<VehicleResponseDto> createVehicle(@RequestBody CreateVehicleDto createVehicleDto) {
        Vehicle vehicle = vehicleService.createVehicle(new Vehicle(createVehicleDto));
        VehicleResponseDto vehicleResponseDto = VehicleResponseDto.fromVehicle(vehicle);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + vehicle.getId())).body(vehicleResponseDto);
    }


}
