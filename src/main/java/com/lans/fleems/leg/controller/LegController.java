package com.lans.fleems.leg.controller;

import com.lans.fleems.leg.service.LegService;
import com.lans.fleems.task.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.legs}")
@AllArgsConstructor
public class LegController {
    private final LegService legService;
    @Value("${api.base-path}${api.controllers.legs}/")
    public static String API_CONTEXT_ROOT;
}
