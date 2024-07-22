package com.lans.fleems.vehicle;

import com.lans.fleems.task.Task;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IVehicleRepository  extends ListCrudRepository<Vehicle, UUID> {
}
