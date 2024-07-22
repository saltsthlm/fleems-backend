package com.lans.fleems.driver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;
}
