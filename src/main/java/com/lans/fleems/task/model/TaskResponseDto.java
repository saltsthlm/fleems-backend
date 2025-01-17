package com.lans.fleems.task.model;

import com.lans.fleems.address.Address;
import com.lans.fleems.client.model.ClientInfoDto;
import com.lans.fleems.client.model.ClientResponseDto;
import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.model.LegInfoDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record TaskResponseDto(UUID id,
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
                              Address startAddress,
                              Address endAddress,
                              ClientInfoDto client,
                              StateEnum state) {
    public static TaskResponseDto fromTask(Task task) {
        return new TaskResponseDto(task.getId(),
                task.getStartDestination(),
                task.getEndDestination(),
                task.getDateCreated(),
                task.getDateFinished(),
                task.getExpectedDistance(),
                task.getExpectedTime(),
                task.getStartDate(),
                task.getProduct(),
                task.getPayload(),
                task.getQuantity(),
                task.getLegs().stream().map(Leg::toInfoDto).toList(),
                task.getStartAddress(),
                task.getEndAddress(),
                ClientInfoDto.fromClient(task.getClient()),
                task.getState()
        );
    }
}
