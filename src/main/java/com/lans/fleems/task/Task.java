package com.lans.fleems.task;


import com.lans.fleems.client.ClientDto;
import com.lans.fleems.client.CreateClientDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Task {

    @Id
    @UuidGenerator
    private UUID id;

    public Task(CreateTaskDto createTaskDto) {
    }

    public Task(TaskDto taskDto) {
        this.id = taskDto.id();
    }
}
