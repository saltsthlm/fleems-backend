package com.lans.fleems.task;


import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ITaskRepository extends ListCrudRepository<Task, UUID> {
}
