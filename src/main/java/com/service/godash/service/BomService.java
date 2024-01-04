package com.service.godash.service;

import com.service.godash.model.BillOfMaterial;
import com.service.godash.payload.BomRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface BomService {

    ResponseEntity<?> createBom(BomRequest bom);
}
