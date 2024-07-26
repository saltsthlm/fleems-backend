package com.lans.fleems.assignment.repository;

import com.lans.fleems.assignment.model.Assignment;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IAssignmentRepository extends ListCrudRepository<Assignment, UUID> {
}
