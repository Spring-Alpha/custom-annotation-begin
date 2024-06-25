package com.example.customannotation.controller;

import com.example.customannotation.service.ComposedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComposedController {
    private final ComposedService composedService;

    public ComposedController(ComposedService composedService) {
        this.composedService = composedService;
    }

    @GetMapping("/perform")
    public String perform() {
        composedService.performTransaction();
        return "Operation performed";
    }
}
