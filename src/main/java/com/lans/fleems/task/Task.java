package com.lans.fleems.task;


import com.lans.fleems.client.Client;
import com.lans.fleems.client.ClientDto;
import com.lans.fleems.client.CreateClientDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
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

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private String startDestination;

    private String endDestination;

    @CreatedDate
    private Date dateCreated;

    private Date dateFinished;

    private String expectedDistance;

    private List<Leg> legs;

    private String product;

    private int payload;

    private int quantity;

    public Task(CreateTaskDto createTaskDto) {
        this.client = createTaskDto.client();
        this.startDestination = createTaskDto.startDestination();
        this.endDestination = createTaskDto.endDestination();
        this.expectedDistance = createTaskDto.expectedDistance();
        this.product = createTaskDto.product();
        this.payload = createTaskDto.payload();
        this.quantity = createTaskDto.quantity();
    }

    public Task(TaskDto taskDto) {
        this.id = taskDto.id();
    }
}
