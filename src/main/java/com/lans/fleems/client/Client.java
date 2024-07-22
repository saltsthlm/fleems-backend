package com.lans.fleems.client;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Client {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 512)
    private String description;

    public Client(CreateClientDto clientDto) {
        this.name = clientDto.name();
    }

    public Client(ClientDto clientDto) {
        this.id = clientDto.id();
        this.name = clientDto.name();
    }
}
