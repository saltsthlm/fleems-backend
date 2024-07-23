package com.lans.fleems.driver.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
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
public class Driver {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(unique=true)
    @Pattern(regexp = "^[0-9]{6}-[0-9]{4}$", message="{invalid.licenseNumber}")
    private String licenseNumber;

    @Column(unique=true)
    @Pattern(regexp = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$", message="{invalid.phoneNumber}")
    private String phoneNumber;

    @Column(unique=true)
    @Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
            + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
            message = "{invalid.email}")
    private String emailAdress;

    public Driver(CreateDriverDto createDriverDto) {

        name= createDriverDto.name();
        licenseNumber= createDriverDto.licenseNumber();
        phoneNumber= createDriverDto.phoneNumber();
        emailAdress= createDriverDto.emailAdress();

    }

    public Driver(DriverDto driverDto) {
        this.id = driverDto.id();
        this.name = driverDto.name();
        this.licenseNumber = driverDto.licenseNumber();
        this.phoneNumber = driverDto.phoneNumber();
        this.emailAdress = driverDto.emailAdress();
    }
}
