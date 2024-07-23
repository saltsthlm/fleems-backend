package com.lans.fleems.client;

import com.lans.fleems.task.Task;

import java.util.List;
import java.util.UUID;

public record ClientResponseDto(UUID id, String name, List<Task> tasks) {
    public static ClientResponseDto fromClient(Client client) {
        return new ClientResponseDto(client.getId(), client.getName(), client.getTasks());
    }
}
