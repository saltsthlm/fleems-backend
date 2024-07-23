package com.lans.fleems.driver;

public record CreateDriverDto(
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAdress
) {
}
