package com.service.godash.controller;

import com.service.godash.model.Supplier;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SupplierResponse;
import com.service.godash.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    SupplierServiceImpl supplierService;

    @PostMapping("/create")
    public ResponseEntity<?> createSupplier(@RequestBody Supplier supplierRequest) {
        supplierService.createSupplier(supplierRequest);
        return ResponseEntity.ok(new MessageResponse("Supplier Created"));

    }

    @GetMapping("/getSupplierList")
    public List<SupplierResponse> getSupplier() throws Exception {
        return  supplierService.getAllSupplier();
    }


}
