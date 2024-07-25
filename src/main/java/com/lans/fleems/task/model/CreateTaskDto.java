package com.lans.fleems.task.model;

import com.lans.fleems.client.model.Client;

import java.time.LocalDateTime;

public record CreateTaskDto(Client client,
                            String startDestination,
                            String endDestination,
                            LocalDateTime startDate,
                            String product,
                            double expectedDistance,
                            int expectedTime,
                            int payload,
                            int quantity) {
}
