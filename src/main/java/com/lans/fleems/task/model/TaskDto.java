package com.lans.fleems.task.model;

import com.lans.fleems.client.model.Client;
import com.lans.fleems.leg.model.Leg;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public record TaskDto(
        UUID id,
        String startDestination,
        String endDestination,
        LocalDateTime dateCreated,
        LocalDateTime dateFinished,
        double expectedDistance,
        int expectedTime,
        LocalDateTime startDate,
        String product,
        double payload,
        int quantity,
        Client client,
        List<Leg> legs) {
}
