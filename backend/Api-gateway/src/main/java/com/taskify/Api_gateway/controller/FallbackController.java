package com.taskify.Api_gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("fallback")
@RestController
public class FallbackController {

    @GetMapping("/serviceA")
    public ResponseEntity<Map<String, String>> serviceAFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Microservice1 is currently unavailable. Please try again later.");
        response.put("status", "SERVICE_UNAVAILABLE");
        return ResponseEntity.status(503).body(response);
    }

    @GetMapping("/serviceB")
    public ResponseEntity<Map<String, String>> serviceBFallback() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Microservice2 is currently unavailable. Please try again later.");
        response.put("status", "SERVICE_UNAVAILABLE");
        return ResponseEntity.status(503).body(response);
    }
}