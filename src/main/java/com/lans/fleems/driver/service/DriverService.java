package com.lans.fleems.driver.service;

import com.lans.fleems.assignments.model.Assignment;
import com.lans.fleems.assignments.repository.AssignmentRepository;
import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.driver.repository.DriverRepository;
import com.lans.fleems.task.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final AssignmentRepository assignmentRepository;

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

    static public byte[] photoStringToByteArray(String photoString) {
        if (photoString == null) {
            return null;
        }
        return photoString.getBytes();
    }

    static public String byteArrayToPhotoString(byte[] photoArray) {
        if (photoArray == null) {
            return null;
        }
        return new String(photoArray);
    }

    public List<Driver> getAssignableDrivers(Task task) {
        LocalDateTime startDate =task.getStartDate();
        LocalDateTime endDate = startDate.plusDays(task.getExpectedTime());
        HashMap<UUID,Driver> drivers = new HashMap<>();
        driverRepository.getAllDrivers().forEach(driver -> drivers.put(driver.getId(),driver));
        assignmentRepository.getAllAssignments()
                .stream()
                .filter(e-> e.getTask()
                        .getStartDate()
                        .isBefore(endDate)&&e.getTask()
                        .getStartDate()
                        .isAfter(startDate)||
                        e.getTask()
                                .getStartDate()
                                .plusDays(e.getTask().getExpectedTime())
                                .isBefore(endDate)
                                && e.getTask()
                                .getStartDate()
                                .plusDays(e.getTask().getExpectedTime())
                                .isAfter(startDate))
                .forEach(e->drivers.remove(e.getDriver().getId()));
        return drivers.values().stream().toList();
    }

}
