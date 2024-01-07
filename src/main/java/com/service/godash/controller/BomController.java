package com.service.godash.controller;

import com.service.godash.payload.SrBomRequest;
import com.service.godash.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bom")
public class BomController {
    @Autowired
    BomService bomService;
    @PostMapping("/create")
    private ResponseEntity<?> createBom(@RequestBody SrBomRequest request){
        bomService.createBom(request);
        return ResponseEntity.ok("BOM Created");
    }
}
