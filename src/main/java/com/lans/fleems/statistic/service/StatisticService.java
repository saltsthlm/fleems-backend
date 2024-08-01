package com.lans.fleems.statistic.service;

import com.lans.fleems.assignment.service.AssignmentService;
import com.lans.fleems.driver.repository.DriverRepository;
import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.repository.LegRepository;
import com.lans.fleems.statistic.models.RestViolation;
import com.lans.fleems.statistic.models.SpeedViolation;
import com.lans.fleems.task.model.StateEnum;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.service.TaskService;
import com.lans.fleems.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class StatisticService {
    private final LegRepository legRepository;
    private final VehicleRepository vehicleRepository;
    private final AssignmentService assignmentService;
    private final TaskService taskService;
    private final DriverRepository driverRepository;

    public List<SpeedViolation> getSpeedViolations() {
       return legRepository.getAllLegs()
               .stream()
               .filter(e->e.getEndTime()!=null)
               .map(this::isSpeedViolation)
               .filter(Objects::nonNull)
               .toList();
    }
    public List<RestViolation> getRestViolations() {
        return legRepository.getAllLegs()
                .stream()
                .filter(e->e.getEndTime()!=null)
                .map(this::isRestViolation)
                .filter(Objects::nonNull)
                .toList();
    }
    private RestViolation isRestViolation(Leg leg){
        double drivingTime = leg.getStartTime().until(leg.getEndTime(), ChronoUnit.MINUTES)/60D;
        if(8>drivingTime){
            return null;
        }
        return new RestViolation(leg.getDriver().getName(),
                drivingTime, leg.getStartTime());

    }
    private SpeedViolation isSpeedViolation(Leg leg){
        double speed =leg.getDistanceDriven()/
                (leg.getStartTime().until(leg.getEndTime(), ChronoUnit.MINUTES)/60D);
        if(90>speed){
            return null;
        }
        return new SpeedViolation(leg.getDriver().getName(),
                speed, leg.getStartTime());

    }

    public int[] getUnassignedAssignedVehicles() {
        int assignedVehicles = assignmentService.getAllActiveAssignments().size();
        int vehicles = vehicleRepository.getAllVehicles().size();
        int[] assignedUnassigned = new int[2];
        assignedUnassigned[0]=assignedVehicles;
        assignedUnassigned[1]=vehicles-assignedVehicles;
        return assignedUnassigned;
    }
    public int[] getUnassignedAssignedDrivers() {
        int assignedDrivers = assignmentService.getAllActiveAssignments().size();
        int drivers = driverRepository.getAllDrivers().size();
        int[] assignedUnassigned = new int[2];
        assignedUnassigned[0]=assignedDrivers;
        assignedUnassigned[1]=drivers-assignedDrivers;
        return assignedUnassigned;
    }
    public int[] taskStatus() {
        List<StateEnum> states = taskService.getAllTasks().stream().map(Task::getState).toList();
        int[] status = new int[4];
        for(StateEnum state: states){
            switch (state) {
                case ASSIGNED -> status[0]++;
                case UNASSIGNED -> status[1]++;
                case ONGOING -> status[2]++;
                case FINISHED -> status[3]++;
            }
        }
        return status;
    }
    public int[] getCompletedThisYear() {
        int[] monthlyAssignments = new int[12];

        List<Task> tasks = taskService.getAllTasks()
                .stream()
                .filter(e->e.getState().equals(StateEnum.FINISHED))
                .filter(e->e.getDateFinished().isAfter(LocalDateTime.now().minusYears(1)))
                .toList();
        tasks
                .forEach(e->
                        monthlyAssignments[(int) e.getDateFinished().until(LocalDateTime.now(),ChronoUnit.YEARS)] ++
                        );
        return monthlyAssignments;
    }
}
