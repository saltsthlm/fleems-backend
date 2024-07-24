package com.lans.fleems.assignments.repository;

import com.lans.fleems.assignments.model.Assignment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AssignmentRepository {
    private final IAssignmentRepository iAssignmentRepository;

    public List<Assignment> getAllAssignments() {
        return iAssignmentRepository.findAll();
    }

    public Assignment createAssignment(Assignment assignment) {
        return iAssignmentRepository.save(assignment);
    }
}
