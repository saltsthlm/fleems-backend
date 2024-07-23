package com.lans.fleems.task.model;

import com.lans.fleems.client.Client;
import com.lans.fleems.leg.Leg;

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
        String product,
        double payload,
        int quantity,
        Client client,
        List<Leg> legs) {
}