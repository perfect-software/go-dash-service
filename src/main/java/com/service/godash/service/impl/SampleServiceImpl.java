package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SampleRequest;
import com.service.godash.repository.BuyerRepo;
import com.service.godash.repository.ColorRepo;
import com.service.godash.repository.SampleRequestRepo;
import com.service.godash.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    SampleRequestRepo sampleRequestRepo;
    @Autowired
    BuyerRepo buyerRepo;
    @Autowired
    ColorRepo colorRepo;
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

    @Override
    public List<Sample> viewSampleRequest(int page_num) {
        Pageable pageable = PageRequest.of(page_num, 12);
        Page<Sample> page = sampleRequestRepo.findAll(pageable);
        List<Sample> resultList = page.getContent();
        return resultList;
    }

    public ResponseEntity<?> updateSampleRequest(SampleRequest request) {
        Sample existingRequest = sampleRequestRepo.findById(request.getSample_id()).orElse(null);
        if (existingRequest != null) {
            // Update the fields as needed
            existingRequest.setSeason(request.getSeason());
            existingRequest.setSampleRef(request.getSampleRef());
            existingRequest.setSampleType(request.getSampleType());
            sampleRequestRepo.save(existingRequest);
            return ResponseEntity.ok(new MessageResponse("Sample Request Updated"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Sample Request not found"));
        }
    }

    @Override
    public List<String> getColor(String input) {
        return colorRepo.findColorContainingIgnoreCase(input);
    }

    @Override
    public List<String> getBuyerSrno(String input) {
        return sampleRequestRepo.findBysrno(input);
    }
}
