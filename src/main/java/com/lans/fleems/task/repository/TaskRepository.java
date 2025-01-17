package com.lans.fleems.task.repository;


import com.lans.fleems.error.exception.NoSuchClientException;
import com.lans.fleems.error.exception.NoSuchTaskException;
import com.lans.fleems.task.model.Task;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class TaskRepository {

    private final ITaskRepository iTaskRepository;

    public List<Task> getAllTasks() {
        return iTaskRepository.findAll();
    }

    public Task getTaskById(UUID taskId) {
        return iTaskRepository.findById(taskId)
                .orElseThrow(NoSuchTaskException::new);
    }

    public Task createTask(Task task) {
        return iTaskRepository.save(task);
    }

    public void deleteById(UUID taskId) {
        if (!iTaskRepository.existsById(taskId)) {
            throw new NoSuchClientException();
        }
        iTaskRepository.deleteById(taskId);
    }

    public Task updateTask(Task task) {
        if (!iTaskRepository.existsById(task.getId())) {
            throw new NoSuchTaskException();
        }
        return iTaskRepository.save(task);

    }
}
