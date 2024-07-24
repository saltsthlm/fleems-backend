package com.lans.fleems.leg.service;

import com.lans.fleems.leg.repository.LegRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LegService {
    private final LegRepository legRepository;
}
