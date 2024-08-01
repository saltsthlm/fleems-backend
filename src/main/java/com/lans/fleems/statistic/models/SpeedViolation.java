package com.lans.fleems.statistic.models;


import java.time.LocalDateTime;

public record SpeedViolation(String driver, double speed, LocalDateTime date) {
}
