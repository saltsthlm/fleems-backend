package com.lans.fleems.client.model;

import java.util.UUID;

public record ClientDto(UUID id,
                        String contactPerson,
                        String contactEmail,
                        String contactPhoneNumber,
                        String name) {
}
