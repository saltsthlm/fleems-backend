package com.lans.fleems.task.model;


import com.lans.fleems.client.model.Client;
import com.lans.fleems.leg.model.Leg;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column
    private LocalDateTime startDate ;

    @Column
    private LocalDateTime dateFinished;

    @Column
    @PositiveOrZero(message="{invalid.expectedDistance}")
    private Double expectedDistance;

    @Column
    @PositiveOrZero(message="{invalid.expectedDistance}")
    private Integer expectedTime;

    @Column(nullable = false)
    private String product;

    @Column
    @PositiveOrZero(message="{invalid.payload}")
    private double payload;

    @Column
    @PositiveOrZero(message="{invalid.quantity}")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "task", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Leg> legs;

    public double getDistanceDriven() {
       return legs.stream().map(Leg::getDistanceDriven).mapToDouble(Double::doubleValue).sum();
    }

    public Task(CreateTaskDto createTaskDto) {
        this.client = createTaskDto.client();
        this.startDestination = createTaskDto.startDestination();
        this.endDestination = createTaskDto.endDestination();
        this.startDate =createTaskDto.startDate();
        this.expectedDistance = createTaskDto.expectedDistance();
        this.expectedTime = createTaskDto.expectedTime();
        this.product = createTaskDto.product();
        this.payload = createTaskDto.payload();
        this.quantity = createTaskDto.quantity();
    }


    public Task(TaskDto taskDto) {
        this.id = taskDto.id();
        this.client = taskDto.client();
        this.startDestination = taskDto.startDestination();
        this.endDestination = taskDto.endDestination();
        this.expectedDistance = taskDto.expectedDistance();
        this.expectedTime = taskDto.expectedTime();
        this.startDate =taskDto.startDate();
        this.dateCreated = taskDto.dateCreated();
        this.dateFinished = taskDto.dateFinished();
        this.product = taskDto.product();
        this.payload = taskDto.payload();
        this.quantity = taskDto.quantity();
    }
    public TaskInfoDto toInfoDto(){
        return new TaskInfoDto(
                 id,
                 startDestination,
                 endDestination,
                 dateCreated,
                 dateFinished,
                expectedDistance,
                expectedTime,
                startDate,
                product,
                payload,
                quantity,
                legs.stream().map(Leg::toInfoDto).toList()
        );
    }
}
