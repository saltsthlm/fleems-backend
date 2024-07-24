package com.lans.fleems.assignments.controller;

import com.lans.fleems.assignments.model.Assignment;
import com.lans.fleems.assignments.model.AssignmentResponseDto;
import com.lans.fleems.assignments.model.CreateAssignmentDto;
import com.lans.fleems.assignments.service.AssignmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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
    @PostMapping
    public ResponseEntity<AssignmentResponseDto> createAssignment(@RequestBody CreateAssignmentDto createAssignmentDto) {
        Assignment createdAssignment = assignmentService.createAssignment(new Assignment(createAssignmentDto));
        AssignmentResponseDto assignmentResponseDto = AssignmentResponseDto.fromAssignment(createdAssignment);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdAssignment.getId())).body(assignmentResponseDto);
    }

}
