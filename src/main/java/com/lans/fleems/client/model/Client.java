package com.lans.fleems.client.model;


import com.lans.fleems.task.model.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Getter
@Setter
public class Client {

    @Id
    @UuidGenerator
    private UUID id;

    @Column
    private String contactPerson;

    @Column(unique=true)
    @Email(message = "{invalid.email}")
    private String contactEmail;

    @Column(unique=true)
    @Pattern(regexp = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$", message="{invalid.phoneNumber}")
    private String contactPhoneNumber;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 512)
    private String description;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public Client(CreateClientDto clientDto) {
        this.contactPerson =clientDto.contactPerson();
        this.contactEmail =clientDto.contactEmail();
        this.contactPhoneNumber =clientDto.contactPhoneNumber();
        this.name = clientDto.name();
    }

    public Client(ClientDto clientDto) {
        this.id = clientDto.id();
        this.contactPerson =clientDto.contactPerson();
        this.contactEmail =clientDto.contactEmail();
        this.contactPhoneNumber =clientDto.contactPhoneNumber();
        this.name = clientDto.name();
    }
}
