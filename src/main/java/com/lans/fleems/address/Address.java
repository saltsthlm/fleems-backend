package com.lans.fleems.address;

import com.lans.fleems.task.model.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Setter
@Getter
@Entity
public class Address {
    @Id
    @UuidGenerator
    private UUID id;
    private String city;
    private String country;
    private String houseNumber;
    private String postcode;
    private String road;
}
