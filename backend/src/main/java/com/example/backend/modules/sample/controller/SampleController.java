package com.example.backend.modules.sample.controller;

import com.example.backend.common.response.ApiResponse;
import com.example.backend.modules.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
@RequiredArgsConstructor
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/ping")
    public ApiResponse<String> ping() {
        return ApiResponse.ok(sampleService.ping());
    }
}
