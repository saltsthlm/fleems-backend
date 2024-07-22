package com.lans.fleems.driver;

import com.lans.fleems.task.CreateTaskDto;
import com.lans.fleems.task.TaskDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
public class Driver {

    @Id
    @UuidGenerator
    private UUID id;

    public Driver(CreateDriverDto createDriverDto) {
    }

    public Driver(DriverDto driverDto) {
        this.id = driverDto.id();
    }
}
