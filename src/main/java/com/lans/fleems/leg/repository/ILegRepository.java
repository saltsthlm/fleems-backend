package com.lans.fleems.leg.repository;

import com.lans.fleems.leg.model.Leg;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface ILegRepository extends ListCrudRepository<Leg, UUID> {
}
