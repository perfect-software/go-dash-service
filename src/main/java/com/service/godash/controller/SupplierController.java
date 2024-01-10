package com.service.godash.controller;

import com.service.godash.model.Supplier;
import com.service.godash.payload.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @PostMapping("/create")
    public ResponseEntity<?> createSupplier(@RequestBody Supplier supplierRequest) {

        return ResponseEntity.ok(new MessageResponse("Supplier Created"));

    }

}
