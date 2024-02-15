package com.service.godash.service;

import com.service.godash.model.SrBom;
import com.service.godash.payload.SampleResponse;
import com.service.godash.payload.SrBomRequest;
import com.service.godash.payload.SrBomResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BomService {

    String createBom(SrBomRequest request);

    List<String> getSRNO();

    List<SrBom> viewSRBOM();

    SrBomResponse getSamplebySrno(String srno);
}
