package com.lans.fleems.task;

import com.lans.fleems.client.Client;
import com.lans.fleems.client.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public Task getTaskById(UUID taskId) {
        return taskRepository.getTaskById(taskId);
    }

    public Task createTask(Task Task) {
        return taskRepository.createTask(Task);
    }

    public void deleteTaskById(UUID taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task updateTask(Task task) {
        return taskRepository.updateTask(task);
    }
}
