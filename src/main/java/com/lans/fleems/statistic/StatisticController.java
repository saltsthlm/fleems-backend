package com.lans.fleems.statistic;

import com.lans.fleems.assignment.model.AssignmentResponseDto;
import com.lans.fleems.leg.model.LegResponseDto;
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

    @GetMapping("/violations/speed")
    public ResponseEntity<List<LegResponseDto>> getSpeedViolations() {
        return ResponseEntity.ok(statisticService.getSpeedViolations()
                .stream()
                .map(LegResponseDto::fromLeg).toList());
    }
    @GetMapping("/violations/rest")
    public ResponseEntity<List<LegResponseDto>> getRestViolations() {
        return ResponseEntity.ok(statisticService.getRestViolations()
                .stream()
                .map(LegResponseDto::fromLeg).toList());
    }

    @GetMapping("/assigned")
    public ResponseEntity<Integer> getPercentOfVehiclesAssigned() {
        return ResponseEntity.ok(statisticService.getPercentOfVehiclesAssigned());
    }

    @GetMapping("/completed")
    public ResponseEntity<int[]> getCompletedThisYear() {
        return ResponseEntity.ok(statisticService.getCompletedThisYear());
    }
}
