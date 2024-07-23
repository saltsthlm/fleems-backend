package com.lans.fleems.client.repository;

import com.lans.fleems.client.model.Client;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IClientRepository extends ListCrudRepository<Client, UUID> {
}
