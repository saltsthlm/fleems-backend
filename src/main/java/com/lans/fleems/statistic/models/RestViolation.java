package com.lans.fleems.statistic.models;

import java.time.LocalDateTime;

public record RestViolation(String driver, double time, LocalDateTime date) {
}
