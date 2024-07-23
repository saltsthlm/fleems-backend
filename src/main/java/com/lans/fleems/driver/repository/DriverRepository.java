package com.lans.fleems.driver.repository;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.error.exception.NoSuchDriverException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class DriverRepository {
    private final IDriverRepository iDriverRepository;
    public List<Driver> getAllDrivers() {
        return iDriverRepository.findAll();
    }

    public Driver getDriverById(UUID driverId) {
        return iDriverRepository.findById(driverId)
                .orElseThrow(NoSuchDriverException::new);
    }

    public Driver createDriver(Driver driver) {
        return iDriverRepository.save(driver);
    }

    public void deleteById(UUID driverId) {
        if (!iDriverRepository.existsById(driverId)) {
            throw new NoSuchDriverException();
        }
        iDriverRepository.deleteById(driverId);
    }

    public Driver updateDriver(Driver driver) {
        if (!iDriverRepository.existsById(driver.getId())) {
            throw new NoSuchDriverException();
        }
        return iDriverRepository.save(driver);
    }
}
