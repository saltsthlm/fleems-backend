package com.lans.fleems.client.model;

import java.util.UUID;

public record ClientInfoDto(
        UUID id,
        String contactPerson,
        String contactEmail,
        String contactPhoneNumber,
        String name) {
    public static ClientInfoDto fromClient(Client client) {
        return new ClientInfoDto(
                client.getId(),
                client.getContactPerson(),
                client.getContactEmail(),
                client.getContactPhoneNumber(),
                client.getName());
    }
}
