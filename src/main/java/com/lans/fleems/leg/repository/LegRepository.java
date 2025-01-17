package com.lans.fleems.leg.repository;

import com.lans.fleems.error.exception.NoSuchClientException;
import com.lans.fleems.error.exception.NoSuchDriverException;
import com.lans.fleems.error.exception.NoSuchLegException;
import com.lans.fleems.leg.model.Leg;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Repository
public class LegRepository {
    private final ILegRepository iLegRepository;

    public List<Leg> getAllLegs() {
        return iLegRepository.findAll();
    }

    public Leg updateLeg(Leg leg) {
        if (!iLegRepository.existsById(leg.getId())) {
            throw new NoSuchLegException();
        }
       return iLegRepository.save(leg);
    }

    public Leg getLegById(UUID id) {
        Leg leg = iLegRepository.findById(id).orElseThrow(NoSuchLegException::new);
        return leg;
    }
}
