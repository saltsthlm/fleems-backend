package com.lans.fleems.client;

import java.util.UUID;

public record ClientResponseDto(UUID id, String name) {
    public static ClientResponseDto fromClient(Client client) {
        return new ClientResponseDto(client.getId(), client.getName());
    }
}
