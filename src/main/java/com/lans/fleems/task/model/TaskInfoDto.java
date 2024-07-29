package com.lans.fleems.task.model;

import com.lans.fleems.leg.model.LegInfoDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TaskInfoDto(
        UUID id,
        String startDestination,
        String endDestination,
        LocalDateTime dateCreated,
        LocalDateTime dateFinished,
        Double expectedDistance,
        Integer expectedTime,
        LocalDateTime startDate,
        String product,
        double payload,
        int quantity,
        List<LegInfoDto> legs,
        StateEnum state
) {
}
