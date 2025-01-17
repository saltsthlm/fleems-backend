package com.lans.fleems.task.model;


import com.lans.fleems.address.Address;
import com.lans.fleems.address.CoordinateService;
import com.lans.fleems.client.model.Client;
import com.lans.fleems.leg.model.Leg;
import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Getter
@Setter
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
    private LocalDateTime startDate;

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
    private List<Leg> legs = new ArrayList<Leg>();

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JoinColumn(name = "startAddress_id")
    private Address startAddress;

    @OneToOne(cascade = {CascadeType.ALL, CascadeType.REMOVE})
    @JoinColumn(name = "endAddress_id")
    private Address endAddress;

    @Column
    @Enumerated(EnumType.STRING)
    private StateEnum state = StateEnum.UNASSIGNED;

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
        this.startAddress = CoordinateService.coordinateStringToJsonString(startDestination);
        this.endAddress = CoordinateService.coordinateStringToJsonString(endDestination);
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
        this.state =taskDto.state();
        this.startAddress = CoordinateService.coordinateStringToJsonString(startDestination);
        this.endAddress = CoordinateService.coordinateStringToJsonString(endDestination);
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
                legs.stream().map(Leg::toInfoDto).toList(),
                state
        );
    }
}
