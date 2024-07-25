package com.lans.fleems.client.model;

public record CreateClientDto(String contactPerson,
                              String contactEmail,
                              String contactPhoneNumber,
                              String name) {
}
