package com.service.godash.controller;

import com.service.godash.model.Buyer;
import com.service.godash.payload.SampleRequest;
import com.service.godash.payload.UserRegistrationRequest;
import com.service.godash.service.BuyerService;
import com.service.godash.service.SampleService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @Autowired
    SampleService sampleService;
    @Autowired
    BuyerService buyerService;

    @PostMapping("/create")
    public ResponseEntity<?> createSample(@Valid @RequestBody SampleRequest request) throws Exception {
        return sampleService.createSampleRequest(request);

    }

    @GetMapping("/getBuyer")
    public List<String> getBuyer(@Valid @RequestParam String input) throws Exception {
        if (input.length() < 3) {
            return Collections.emptyList();
        }
        return buyerService.getBuyerByPartialName(input);

    }

    @GetMapping("/getAllBuyer")
    public List<Buyer> getAllBuyer(@Valid @RequestParam String input) throws Exception {
        if (input.length() < 3) {
            return Collections.emptyList();
        }
        return buyerService.getBuyerByName(input);

    }


}
