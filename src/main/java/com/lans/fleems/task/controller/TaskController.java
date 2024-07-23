package com.lans.fleems.task.controller;

import com.lans.fleems.task.service.TaskService;
import com.lans.fleems.task.model.CreateTaskDto;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.model.TaskDto;
import com.lans.fleems.task.model.TaskResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.tasks}")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @Value("${api.base-path}${api.controllers.tasks}/")
    public static String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks.stream().map(TaskResponseDto::fromTask).toList());
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable UUID taskId) {
        Task task = taskService.getTaskById(taskId);
        return ResponseEntity.ok(TaskResponseDto.fromTask(task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable UUID taskId) {
        taskService.deleteTaskById(taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<TaskResponseDto> updateClient(@RequestBody TaskDto taskDto) {
        Task task = taskService.updateTask(new Task(taskDto));
        return ResponseEntity.ok(TaskResponseDto.fromTask(task));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createClient(@RequestBody CreateTaskDto taskDto) {
        Task createdTask = taskService.createTask(new Task(taskDto));
        TaskResponseDto taskResponseDto = TaskResponseDto.fromTask(createdTask);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdTask.getId())).body(taskResponseDto);
    }
}
