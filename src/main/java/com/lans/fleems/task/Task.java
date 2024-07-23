package com.lans.fleems.task;


import com.lans.fleems.client.Client;
import com.lans.fleems.leg.Leg;
import com.lans.fleems.leg.LegInfoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
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

    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();

    @Column
    private LocalDateTime dateFinished;

    @Column
    @Min(value = 0, message="{invalid.expectedDistance}")
    private double expectedDistance;

    @Column(nullable = false)
    private String product;

    @Column
    @Min(value = 0, message="{invalid.payload}")
    private double payload;

    @Column
    @Min(value = 0, message="{invalid.quantity}")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Leg> legs;

    public double getDistanceDriven() {
       return legs.stream().map(Leg::getDistanceDriven).mapToDouble(Double::doubleValue).sum();
    }

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
        this.client = taskDto.client();
        this.startDestination = taskDto.startDestination();
        this.endDestination = taskDto.endDestination();
        this.expectedDistance = taskDto.expectedDistance();
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
                product,
                payload,
                quantity,
                legs.stream().map(Leg::toInfoDto).toList()
        );
    }
}
