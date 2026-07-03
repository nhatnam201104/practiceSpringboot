package com.example.backend.modules.sample.service;

import com.example.backend.modules.sample.mapper.SampleMapper;
import com.example.backend.modules.sample.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final SampleRepository sampleRepository;
    private final SampleMapper sampleMapper;

    public String ping() {
        return "pong";
    }
}
