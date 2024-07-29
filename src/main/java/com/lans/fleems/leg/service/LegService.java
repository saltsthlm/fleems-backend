package com.lans.fleems.leg.service;

import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.repository.LegRepository;
import com.lans.fleems.task.model.StateEnum;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.repository.TaskRepository;
import com.lans.fleems.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class LegService {
    private final LegRepository legRepository;
    private final TaskRepository taskRepository;

    public List<Leg> getAllLegsForVehicle(UUID vehicleId) {
        return legRepository.getAllLegs().stream().filter(e->e.getVehicle().getId().equals(vehicleId)).toList();
    }
    public List<Leg> getAllLegsForDriver(UUID driverId) {
        return legRepository.getAllLegs().stream().filter(e->e.getDriver().getId().equals(driverId)).toList();
    }

    public Leg finishLeg(Leg leg) {
        Task task = leg.getTask();
        if(Objects.equals(task.getEndDestination(), leg.getEndLocation())){
            task.setState(StateEnum.FINISHED);
            taskRepository.updateTask(task);
        }
        Vehicle vehicle = leg.getVehicle();
        vehicle.setDistanceDriven(vehicle.getDistanceDriven()+leg.getDistanceDriven());
        leg.setVehicle(vehicle);
        return legRepository.updateLeg(leg);
    }

    public List<Leg> getAllLegs() {
        return legRepository.getAllLegs();
    }
}
