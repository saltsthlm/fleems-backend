package com.lans.fleems.vehicle.repository;

import com.lans.fleems.vehicle.model.Vehicle;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface IVehicleRepository  extends ListCrudRepository<Vehicle, UUID> {
}
