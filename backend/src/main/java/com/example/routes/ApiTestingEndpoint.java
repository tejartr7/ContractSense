package com.example.routes;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
public class ApiTestingEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(ApiTestingEndpoint.class);

    @PostMapping("/test")
    public ResponseEntity<?> handleRequest(@RequestBody Map<String, String> requestBody) {
        logger.info("Received request body: {}", requestBody);
        return ResponseEntity.ok("Received Data: " + requestBody.get("id"));
    }
}
