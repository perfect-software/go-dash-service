package com.service.godash.service;

import com.service.godash.model.SrBom;
import com.service.godash.model.SrBomDetails;
import com.service.godash.payload.SrBomRequest;
import com.service.godash.payload.SrBomResponse;

import java.util.List;
import java.util.Optional;

public interface BomService {

    String createBom(SrBomRequest request);

    List<String> getSRNO();

    List<SrBom> viewSRBOM();

    SrBomResponse getSamplebySrno(String srno);

    SrBomDetails getSrBomDetails(Integer bomId);
}
