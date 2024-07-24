package com.lans.fleems.leg.repository;

import com.lans.fleems.leg.model.Leg;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class LegRepository {
    private final ILegRepository iLegRepository;

    public List<Leg> getAllLegs() {
        return iLegRepository.findAll();
    }
}
