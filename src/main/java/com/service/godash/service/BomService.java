package com.service.godash.service;

import com.service.godash.payload.SrBomRequest;
import org.springframework.http.ResponseEntity;

public interface BomService {

    String createBom(SrBomRequest request);
}
