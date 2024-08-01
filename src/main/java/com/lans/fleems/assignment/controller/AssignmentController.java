package com.lans.fleems.assignment.controller;

import com.lans.fleems.assignment.model.Assignment;
import com.lans.fleems.assignment.model.AssignmentResponseDto;
import com.lans.fleems.assignment.model.CreateAssignmentDto;
import com.lans.fleems.assignment.service.AssignmentService;
import com.lans.fleems.task.model.TaskResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.assignments}")
@AllArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Value("${api.base-path}${api.controllers.assignments}")
    public static String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<AssignmentResponseDto>> getAllAssignments() {
       return ResponseEntity.ok(assignmentService.getAllAssignments().stream().map(AssignmentResponseDto::fromAssignment).toList());
    }

    @GetMapping("/active")
    public ResponseEntity<List<AssignmentResponseDto>> getAllActiveAssignments() {
        return ResponseEntity.ok(assignmentService.getAllActiveAssignments().stream().map(AssignmentResponseDto::fromAssignment).toList());
    }

    @PostMapping
    public ResponseEntity<AssignmentResponseDto> createAssignment(@RequestBody CreateAssignmentDto createAssignmentDto) {
        Assignment createdAssignment = assignmentService.createAssignment(
                createAssignmentDto.driverId(),
                createAssignmentDto.vehicleId(),
                createAssignmentDto.taskId());
        AssignmentResponseDto assignmentResponseDto = AssignmentResponseDto.fromAssignment(createdAssignment);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdAssignment.getId())).body(assignmentResponseDto);
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<List<TaskResponseDto>> getTasksForVehicle(@PathVariable UUID vehicleId) {
        return ResponseEntity.ok(assignmentService.getTasksForVehicle(vehicleId).stream().map(TaskResponseDto::fromTask).toList());
    }
    @GetMapping("/{driverId}")
    public ResponseEntity<List<TaskResponseDto>> getTasksForDriver(@PathVariable UUID driverId) {
        return ResponseEntity.ok(assignmentService.getTasksForDriver(driverId).stream().map(TaskResponseDto::fromTask).toList());
    }
}
