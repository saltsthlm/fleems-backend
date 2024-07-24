package com.lans.fleems.leg.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class LegRepository {
    private final ILegRepository iLegRepository;
}
