package com.lans.fleems.driver.repository;


import com.lans.fleems.driver.model.Driver;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IDriverRepository extends ListCrudRepository<Driver, UUID> {
}
