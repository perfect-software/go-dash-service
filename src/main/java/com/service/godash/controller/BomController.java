package com.service.godash.controller;

import com.service.godash.payload.BomRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bom")
public class BomController {
    @PostMapping("/create")
    private ResponseEntity<?> createBom(@RequestBody BomRequest request){
        return null;
    }
}
