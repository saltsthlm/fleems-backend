package com.lans.fleems.task.service;

import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.repository.TaskRepository;
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
