package com.lans.fleems.task;


import com.lans.fleems.client.ClientDto;
import com.lans.fleems.client.CreateClientDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
