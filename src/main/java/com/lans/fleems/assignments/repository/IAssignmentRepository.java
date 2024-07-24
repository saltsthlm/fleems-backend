package com.lans.fleems.assignments.repository;

import com.lans.fleems.assignments.model.Assignment;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IAssignmentRepository extends ListCrudRepository<Assignment, UUID> {
}
