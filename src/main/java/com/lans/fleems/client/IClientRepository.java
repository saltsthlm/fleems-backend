package com.lans.fleems.client;

import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IClientRepository extends ListCrudRepository<Client, UUID> {
}
