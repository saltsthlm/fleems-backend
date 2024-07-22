package com.lans.fleems.task;


import java.util.UUID;

public record TaskResponseDto(UUID id) {
    public static TaskResponseDto fromTask(Task task) {
        return new TaskResponseDto(task.getId());
    }
}
