package com.lans.fleems.assignmentconnections.service;

import com.lans.fleems.assignmentconnections.model.Assignment;
import com.lans.fleems.assignmentconnections.repository.AssignmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.getAllAssignments();
    }

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.createAssignment(assignment);
    }
}
