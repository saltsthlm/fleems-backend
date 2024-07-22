package com.lans.fleems.driver;

import com.lans.fleems.error.NoSuchClientException;
import com.lans.fleems.error.NoSuchDriverException;
import com.lans.fleems.error.NoSuchTaskException;
import com.lans.fleems.task.Task;
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
        if (iDriverRepository.existsById(driverId)) {
            iDriverRepository.deleteById(driverId);
        }
        throw new NoSuchDriverException();
    }

    public Driver updateDriver(Driver driver) {
        if (iDriverRepository.existsById(driver.getId())) {
            return iDriverRepository.save(driver);
        }
        throw new NoSuchDriverException();
    }
}
