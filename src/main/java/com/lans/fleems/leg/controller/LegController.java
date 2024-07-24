package com.lans.fleems.leg.controller;

import com.azure.core.annotation.Get;
import com.lans.fleems.leg.model.LegResponseDto;
import com.lans.fleems.leg.service.LegService;
import com.lans.fleems.task.model.TaskResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.legs}")
@AllArgsConstructor
public class LegController {
    private final LegService legService;
    @Value("${api.base-path}${api.controllers.legs}/")
    public static String API_CONTEXT_ROOT;

    @Get("/{vehicleId}/vehicle")
    ResponseEntity<List<LegResponseDto>> getAllLegsForVehicle(@PathVariable UUID vehicleId){
        return ResponseEntity.ok(legService.getAllLegsForVehicle(vehicleId).stream().map(LegResponseDto::fromLeg).toList());
    }
    @Get("/{driverID}/vehicle")
    ResponseEntity<List<LegResponseDto>> getAllLegsForDriver(@PathVariable UUID driverID){
        return ResponseEntity.ok(legService.getAllLegsForDriver(driverID).stream().map(LegResponseDto::fromLeg).toList());
    }

}
