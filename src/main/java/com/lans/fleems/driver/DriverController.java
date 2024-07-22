package com.lans.fleems.driver;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("${api.base-path}${api.controllers.drivers}")
public class DriverController {

    private final DriverService driverService;

    @Value("${api.base-path}${api.controllers.drivers}/")
    public String API_CONTEXT_ROOT;


}
