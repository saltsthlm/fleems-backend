package com.lans.fleems.statistic.controller;

import com.lans.fleems.statistic.service.StatisticService;
import com.lans.fleems.statistic.models.RestViolation;
import com.lans.fleems.statistic.models.SpeedViolation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.stats}")
@AllArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/speed")
    public ResponseEntity<List<SpeedViolation>> getSpeedViolations() {
        return ResponseEntity.ok(statisticService.getSpeedViolations());
    }
    @GetMapping("/rest")
    public ResponseEntity<List<RestViolation>> getRestViolations() {
        return ResponseEntity.ok(statisticService.getRestViolations());
    }

    @GetMapping("/vehicle")
    public ResponseEntity<int[]> unassignedAssignedVehicles() {
        return ResponseEntity.ok(statisticService.getUnassignedAssignedVehicles());
    }
    @GetMapping("/driver")
    public ResponseEntity<int[]> unassignedAssignedDrivers() {
        return ResponseEntity.ok(statisticService.getUnassignedAssignedDrivers());
    }
    @GetMapping("/tasks")
    public ResponseEntity<int[]> taskStatus() {
        return ResponseEntity.ok(statisticService.taskStatus());
    }

    @GetMapping("/completed")
    public ResponseEntity<int[]> getCompletedThisYear() {
        return ResponseEntity.ok(statisticService.getCompletedThisYear());
    }
}
