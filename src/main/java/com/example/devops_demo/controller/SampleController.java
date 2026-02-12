package com.example.devops_demo.controller;

import com.example.devops_demo.service.SampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/tell-something")
    public ResponseEntity<String> responseSomething() {

        return ResponseEntity.ok(sampleService.returnSomething());
    }
}
