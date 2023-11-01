package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SampleRequest;
import com.service.godash.repository.BuyerRepo;
import com.service.godash.repository.SampleRequestRepo;
import com.service.godash.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    SampleRequestRepo sampleRequestRepo;
    @Autowired
    BuyerRepo buyerRepo;
    @Override
    public ResponseEntity<?> createSampleRequest(SampleRequest request) {
        Sample sample=new Sample(request);
        Buyer buyer=new Buyer();
        Buyer existingBuyer = buyerRepo.findByBsName(request.getBsName());
        buyer.setBsId(existingBuyer.getBsId());
        sample.setBuyer(buyer);
        sampleRequestRepo.save(sample);
        return ResponseEntity.ok(new MessageResponse("Sample Request Created"));
    }
}
