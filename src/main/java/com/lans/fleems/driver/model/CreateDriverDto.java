package com.lans.fleems.driver.model;

public record CreateDriverDto(
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAdress
) {
}
