package com.lans.fleems.task.controller;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.driver.service.DriverService;
import com.lans.fleems.leg.model.CreateLegDto;
import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.task.model.*;
import com.lans.fleems.task.service.TaskService;
import com.lans.fleems.vehicle.model.Vehicle;
import com.lans.fleems.vehicle.service.VehicleService;
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
    private final DriverService driverService;
    private final VehicleService vehicleService;

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
    @PutMapping("/leg")
    public ResponseEntity<TaskResponseDto> addLeg(@RequestBody CreateLegDto createLegDto) {
        Task task = taskService.getTaskById(createLegDto.taskId());
        Vehicle vehicle = vehicleService.getVehicleById(createLegDto.vehicleId());
        Driver driver = driverService.getDriverById(createLegDto.driverId());

        task.setState(StateEnum.ONGOING);
        taskService.updateTask(task);

        return ResponseEntity.ok(TaskResponseDto
                .fromTask(taskService.addLeg(new Leg(createLegDto,task,driver,vehicle), task.getId())));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody CreateTaskDto taskDto) {
        Task createdTask = taskService.createTask(new Task(taskDto));
        TaskResponseDto taskResponseDto = TaskResponseDto.fromTask(createdTask);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdTask.getId())).body(taskResponseDto);
    }




}
