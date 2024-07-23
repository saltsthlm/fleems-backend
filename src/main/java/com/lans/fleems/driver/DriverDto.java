package com.lans.fleems.driver;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

public record DriverDto(
        UUID id,
        String name,
        String licenseNumber,
        String phoneNumber,
        String emailAdress) {
}

