package com.lans.fleems.task.repository;


import com.lans.fleems.task.model.Task;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ITaskRepository extends ListCrudRepository<Task, UUID> {
}
