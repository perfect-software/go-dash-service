package com.service.godash.service;

import com.service.godash.payload.SampleRequest;
import org.springframework.http.ResponseEntity;

public interface SampleService {

    ResponseEntity<?> createSampleRequest(SampleRequest request);
}
