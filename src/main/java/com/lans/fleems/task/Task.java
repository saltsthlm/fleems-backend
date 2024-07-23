package com.lans.fleems.task;


import com.lans.fleems.client.Client;
import com.lans.fleems.client.ClientDto;
import com.lans.fleems.client.CreateClientDto;
import com.lans.fleems.leg.Leg;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;
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

    @Column(nullable = false)
    private String startDestination;

    @Column(nullable = false)
    private String endDestination;

    @CreatedDate
    @Column(nullable = false)
    private Date dateCreated;

    @Column
    private Date dateFinished;

    @Column
    private String expectedDistance;

    @Column
    private String product;

    @Column
    private double payload;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Leg> legs;

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
