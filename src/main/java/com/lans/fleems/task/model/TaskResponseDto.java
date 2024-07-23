package com.lans.fleems.task.model;


import com.lans.fleems.leg.Leg;
import com.lans.fleems.leg.LegInfoDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TaskResponseDto(UUID id,
                              String startDestination,
                              String endDestination,
                              LocalDateTime dateCreated,
                              LocalDateTime dateFinished,
                              double expectedDistance,
                              String product,
                              double payload,
                              int quantity,
                              List<LegInfoDto> legs) {
    public static TaskResponseDto fromTask(Task task) {
        return new TaskResponseDto(task.getId(),
                task.getStartDestination(),
                task.getEndDestination(),
                task.getDateCreated(),
                task.getDateFinished(),
                task.getExpectedDistance(),
                task.getProduct(),
                task.getPayload(),
                task.getQuantity(),
                task.getLegs().stream().map(Leg::toInfoDto).toList()
        );
    }
}
