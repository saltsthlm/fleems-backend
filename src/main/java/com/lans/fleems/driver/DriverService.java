package com.lans.fleems.driver;

import com.lans.fleems.task.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;

    public List<Driver> getAllDrivers() {
        return driverRepository.getAllDrivers();
    }

    public Driver getDriverById(UUID driverId) {
        return driverRepository.getDriverById(driverId);
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.createDriver(driver);
    }

    public void deleteDriverById(UUID driverId) {
        driverRepository.deleteById(driverId);
    }

    public Driver updateDriver(Driver driver) {
        return driverRepository.updateDriver(driver);
    }
}
