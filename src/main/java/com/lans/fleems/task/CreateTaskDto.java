package com.lans.fleems.task;

import com.lans.fleems.client.Client;

public record CreateTaskDto(Client client, String startDestination, String endDestination, String expectedDistance,
                            String product, int payload, int quantity) {
}
