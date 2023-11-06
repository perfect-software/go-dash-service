package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.model.SampleType;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SampleRequest;
import com.service.godash.repository.*;
import com.service.godash.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class SampleServiceImpl implements SampleService {
    @Autowired
    SampleRequestRepo sampleRequestRepo;
    @Autowired
    BuyerRepo buyerRepo;
    @Autowired
    ColorRepo colorRepo;
    @Autowired
    SampleTypeRepo sampleTypeRepo;
    @Autowired
    SampleRefRepo refRepo;

    @Override
    public ResponseEntity<?> createSampleRequest(SampleRequest request) {
        String season=request.getSeason();
        String year=getYear();
        request.setSeason(season+year);
        Sample sample=new Sample(request);
        Buyer buyer=new Buyer();
        Buyer existingBuyer = buyerRepo.findByBsName(request.getBsName());
        buyer.setBs_id(existingBuyer.getBs_id());
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
    public List<String> getBuyerSrno(String input,int bsId) {
        if (input.length() < 2) {
            return refRepo.findBybuyersrno(bsId);
        }
        return refRepo.findBysrno(input,bsId);
    }

    @Override
    public List<SampleType> getSampleType() {
        return sampleTypeRepo.findAll();
    }

    public String getYear(){
        Year currentYear = Year.now();
        String currentYearAsString = currentYear.toString();
        String year = currentYearAsString.substring(currentYearAsString.length() - 2);
        return year;
    }

}
