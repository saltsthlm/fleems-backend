package com.lans.fleems.task;

import com.lans.fleems.client.Client;
import com.lans.fleems.leg.Leg;

import java.util.Date;
import java.util.List;
import java.util.UUID;


public record TaskDto(
        UUID id,
        String startDestination,
        String endDestination,
        Date dateCreated,
        Date dateFinished,
        String expectedDistance,
        String product,
        double payload,
        int quantity,
        Client client,
        List<Leg> legs) {
}
