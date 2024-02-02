package com.service.godash.service;

import com.service.godash.model.Sample;
import com.service.godash.payload.SampleRequest;
import com.service.godash.payload.SampleResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SampleService {

    String createSampleRequest(SampleRequest request) throws Exception;

    List<Sample> viewSampleRequest(int page_num);


    ResponseEntity<?> updateSampleRequest(SampleRequest request);

    List<String> getColor(String input);

    List<String> getBuyerSrno(String input,int bsId);

    List<String> getSampleType();

    List<SampleResponse> viewAllSampleRequest();

}
