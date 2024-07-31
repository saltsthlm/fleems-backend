package com.lans.fleems.leg.service;

import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.repository.LegRepository;
import com.lans.fleems.task.model.StateEnum;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Service
public class LegService {
    private final LegRepository legRepository;

    public List<Leg> getAllLegsForVehicle(UUID vehicleId) {
        return legRepository.getAllLegs().stream().filter(e -> e.getVehicle().getId().equals(vehicleId)).toList();
    }

    public List<Leg> getAllLegsForDriver(UUID driverId) {
        return legRepository.getAllLegs().stream().filter(e -> e.getDriver().getId().equals(driverId)).toList();
    }

    public Leg finishLeg(Leg leg) {
        Leg updatedLeg = getLegById(leg.getId());
        updatedLeg.setDistanceDriven(updatedLeg.getDistanceDriven() + leg.getDistanceDriven());
        updatedLeg.setEndLocation(leg.getEndLocation());
        updatedLeg.setEndAddress(leg.getEndAddress());
        updatedLeg.setEndTime(leg.getEndTime());
        Task task = updatedLeg.getTask();
        if (Objects.equals(task.getEndDestination(), updatedLeg.getEndLocation())) {
            task.setState(StateEnum.FINISHED);
            task.setDateFinished(updatedLeg.getEndTime());
            updatedLeg.setTask(task);
        }
        Vehicle vehicle = updatedLeg.getVehicle();
        vehicle.setDistanceDriven(vehicle.getDistanceDriven() + updatedLeg.getDistanceDriven());
        updatedLeg.setVehicle(vehicle);
        return legRepository.updateLeg(updatedLeg);
    }

    public List<Leg> getAllLegs() {
        return legRepository.getAllLegs();
    }

    public Leg getLegById(UUID id) {
        return legRepository.getLegById(id);
    }
}
