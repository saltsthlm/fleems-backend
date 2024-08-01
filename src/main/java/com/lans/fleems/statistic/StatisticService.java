package com.lans.fleems.statistic;

import com.lans.fleems.assignment.model.Assignment;
import com.lans.fleems.assignment.repository.AssignmentRepository;
import com.lans.fleems.assignment.service.AssignmentService;
import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.repository.LegRepository;
import com.lans.fleems.task.model.StateEnum;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.service.TaskService;
import com.lans.fleems.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@AllArgsConstructor
public class StatisticService {
    private final LegRepository legRepository;
    private final VehicleRepository vehicleRepository;
    private final AssignmentRepository assignmentRepository;
    private final AssignmentService assignmentService;
    private final TaskService taskService;

    public List<Leg> getSpeedViolations() {
       return legRepository.getAllLegs().stream().filter(this::isSpeedViolation).toList();
    }
    public List<Leg> getRestViolations() {
        return legRepository.getAllLegs().stream().filter(this::isRestViolation).toList();
    }
    private boolean isRestViolation(Leg leg){
        if(leg.getEndTime()==null){
            return false;
        }
        return 8<(leg.getStartTime().until(leg.getEndTime(), ChronoUnit.HOURS));
    }
    private boolean isSpeedViolation(Leg leg){
        if(leg.getEndTime()==null){
            return false;
        }
        return 90<(leg.getDistanceDriven()/
                (leg.getStartTime().until(leg.getEndTime(), ChronoUnit.HOURS)));
    }

    public int[] getUnassignedAssignedVehicles() {
        int assignedVehicles = assignmentService.getAllActiveAssignments().size();
        int vehicles = vehicleRepository.getAllVehicles().size();
        int[] assignedUnassigned = new int[2];
        assignedUnassigned[0]=assignedVehicles;
        assignedUnassigned[1]=vehicles-assignedVehicles;
        return assignedUnassigned;
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
