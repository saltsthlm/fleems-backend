package com.lans.fleems.driver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DriverRepository {
    private final IDriverRepository iDriverRepository;

}
