package com.example.burbujas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PublicController {

    @GetMapping("/info")
    public Map<String, String> getInfo() {
        return Map.of(
                "app", "Burbujas",
                "version", "0.0.1",
                "description", "Burbujeando ando"
        );
    }

    @GetMapping("/health")
    public Map<String, String> healthCheck() {
        return Map.of("status", "UP");
    }
}