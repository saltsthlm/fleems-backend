package com.lans.fleems.assignmentconnections.repository;

import com.lans.fleems.assignmentconnections.model.Assignment;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IAssignmentRepository extends ListCrudRepository<Assignment, UUID> {
}
