package com.lans.fleems.assignments.service;

import com.lans.fleems.assignments.model.Assignment;
import com.lans.fleems.assignments.repository.AssignmentRepository;
import lombok.AllArgsConstructor;
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
