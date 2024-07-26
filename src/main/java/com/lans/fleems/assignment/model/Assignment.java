package com.lans.fleems.assignment.model;

import com.lans.fleems.driver.model.Driver;
import com.lans.fleems.task.model.Task;
import com.lans.fleems.vehicle.model.Vehicle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Assignment {

    @Id
    @UuidGenerator
    private UUID id;

    @OneToOne
    private Task task;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Vehicle vehicle;

    public Assignment(Task task, Driver driver, Vehicle vehicle) {
        this.task = task;
        this.driver = driver;
        this.vehicle = vehicle;
    }
}
