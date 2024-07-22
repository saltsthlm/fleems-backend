package com.lans.fleems.task;


import com.lans.fleems.client.Client;
import com.lans.fleems.error.NoSuchClientException;
import com.lans.fleems.error.NoSuchTaskException;
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
        if (iTaskRepository.existsById(taskId)) {
            iTaskRepository.deleteById(taskId);
        }
        throw new NoSuchClientException();
    }

    public Task updateTask(Task task) {
        if (iTaskRepository.existsById(task.getId())) {
            return iTaskRepository.save(task);
        }
        throw new NoSuchTaskException();
    }
}
