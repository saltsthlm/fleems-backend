package com.lans.fleems.leg.controller;

import com.azure.core.annotation.Get;
import com.azure.core.annotation.Put;
import com.lans.fleems.leg.model.Leg;
import com.lans.fleems.leg.model.LegResponseDto;
import com.lans.fleems.leg.service.LegService;
import com.lans.fleems.task.model.TaskResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{vehicleId}/vehicle")
    public ResponseEntity<List<LegResponseDto>> getAllLegsForVehicle(@PathVariable UUID vehicleId){
        return ResponseEntity.ok(legService.getAllLegsForVehicle(vehicleId).stream().map(LegResponseDto::fromLeg).toList());
    }
    @GetMapping("/{driverID}/vehicle")
    public ResponseEntity<List<LegResponseDto>> getAllLegsForDriver(@PathVariable UUID driverID){
        return ResponseEntity.ok(legService.getAllLegsForDriver(driverID).stream().map(LegResponseDto::fromLeg).toList());
    }
    @PutMapping("/finnish")
    public ResponseEntity<LegResponseDto> finnishLeg(@RequestBody Leg leg){
        return ResponseEntity.ok(LegResponseDto.fromLeg(legService.finnishLeg(leg)));
    }

}
