package com.lans.fleems.driver;

import com.lans.fleems.task.CreateTaskDto;
import com.lans.fleems.task.TaskDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.format.annotation.NumberFormat;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Driver {

    @Id
    @UuidGenerator
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String licenseNumber;

    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String phoneNumber;

    @NotNull(message="{email.required}")
    @Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
            + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
            message = "{invalid.email}")
    private String emailAdress;

    public Driver(CreateDriverDto createDriverDto) {
    }

    public Driver(DriverDto driverDto) {
        this.id = driverDto.id();
    }
}
