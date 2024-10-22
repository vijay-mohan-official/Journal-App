package com.learning.journalApp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Health Check API", description = "Hit to check if service is Up")
public class HealthCheckController {

    @GetMapping("/health-check")
    @Operation(summary = "Hit to check if the service is Up and running")
    public String healthCheck(){
        return "OK";
    }

}
