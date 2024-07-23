package com.lans.fleems.task.model;

import com.lans.fleems.client.model.Client;

public record CreateTaskDto(Client client,
                            String startDestination,
                            String endDestination,
                            double expectedDistance,
                            String product,
                            int payload,
                            int quantity) {
}
