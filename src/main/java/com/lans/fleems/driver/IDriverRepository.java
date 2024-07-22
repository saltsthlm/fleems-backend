package com.lans.fleems.driver;


import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IDriverRepository extends ListCrudRepository<Driver, UUID> {
}
