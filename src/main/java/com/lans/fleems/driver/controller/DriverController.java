package com.lans.fleems.driver.controller;

import com.lans.fleems.driver.service.DriverService;
import com.lans.fleems.driver.model.CreateDriverDto;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.driver.model.DriverDto;
import com.lans.fleems.driver.model.DriverResponseDto;
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
@RequestMapping("${api.base-path}${api.controllers.drivers}")
public class DriverController {

    private final DriverService driverService;

    @Value("${api.base-path}${api.controllers.drivers}/")
    public static String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<DriverResponseDto>> getAllDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return ResponseEntity.ok(drivers.stream().map(DriverResponseDto::fromDriver).toList());
    }

    @GetMapping("/{driverId}")
    public ResponseEntity<DriverResponseDto> getDriverById(@PathVariable UUID driverId) {
        Driver driver = driverService.getDriverById(driverId);
        return ResponseEntity.ok(DriverResponseDto.fromDriver(driver));
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> deleteDriverById(@PathVariable UUID driverId) {
        driverService.deleteDriverById(driverId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<DriverResponseDto> updateDriver(@RequestBody DriverDto driverDto) {
        Driver driver = driverService.updateDriver(new Driver(driverDto));
        return ResponseEntity.ok(DriverResponseDto.fromDriver(driver));
    }

    @PostMapping
    public ResponseEntity<DriverResponseDto> createClient(@RequestBody CreateDriverDto createDriverDto) {
        Driver driver = driverService.createDriver(new Driver(createDriverDto));
        DriverResponseDto driverResponseDto = DriverResponseDto.fromDriver(driver);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + driver.getId())).body(driverResponseDto);
    }


}
