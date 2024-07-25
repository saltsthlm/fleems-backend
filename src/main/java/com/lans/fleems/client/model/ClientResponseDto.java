package com.lans.fleems.client.model;

import com.lans.fleems.task.model.Task;
import com.lans.fleems.task.model.TaskInfoDto;

import java.util.List;
import java.util.UUID;

public record ClientResponseDto(
        UUID id,
        String contactPerson,
        String contactEmail,
        String contactPhoneNumber,
        String name,
        List<TaskInfoDto> tasks) {
    public static ClientResponseDto fromClient(Client client) {
        return new ClientResponseDto(
                client.getId(),
                client.getContactPerson(),
                client.getContactEmail(),
                client.getContactPhoneNumber(),
                client.getName(),
                client.getTasks().stream().map(Task::toInfoDto).toList());
    }
}
