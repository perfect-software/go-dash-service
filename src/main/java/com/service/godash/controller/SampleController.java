package com.service.godash.controller;

import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.BuyerResponse;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SampleRequest;
import com.service.godash.payload.SampleResponse;
import com.service.godash.service.BuyerService;
import com.service.godash.service.SampleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @Autowired
    SampleService sampleService;
    @Autowired
    BuyerService buyerService;

    @PostMapping("/create")
    public ResponseEntity<?> createSample(@Valid @RequestBody SampleRequest request) throws Exception {
        return sampleService.createSampleRequest(request);

    }

    @GetMapping("/view/{page_num}")
    public List<Sample> viewSample(@Valid @RequestParam int page_num) throws Exception {
        return sampleService.viewSampleRequest(page_num);
    }

    @GetMapping("/viewAllSample")
    public List<SampleResponse> viewAllSample() throws Exception {
        return sampleService.viewAllSampleRequest();
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSampleRequest(@RequestBody SampleRequest request) {
        try {
            return sampleService.updateSampleRequest(request);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Update failed: " + e.getMessage()));
        }
    }

    @GetMapping("/getBuyer")
    public List<BuyerResponse> getBuyer(@Valid @RequestParam String input) throws Exception {
        if (input.length() < 3) {
            return Collections.emptyList();
        }
        return buyerService.getBuyerByPartialName(input);

    }

    @GetMapping("/getAllBuyerByPage/{page_num}")
    public List<Buyer> getAllBuyer(@Valid @RequestParam int page_num) throws Exception {
       return buyerService.getBuyerByName(page_num);
    }

    @GetMapping("/getAllBuyer")
    public List<Buyer> getAllBuyer() throws Exception {
        return buyerService.getAllBuyer();
    }

    @GetMapping("/color/{input}")
    public List<String> getColor(@RequestParam String input){
        if (input.length() < 2) {
            return Collections.emptyList();
        }
        return sampleService.getColor(input);
    }
    @GetMapping("/getSRNO/{bsId}") //get SRNO of Same Buyer
    public List<String> getSRNO(@RequestParam String input,@RequestParam int bsId){
        return sampleService.getBuyerSrno(input,bsId);
    }
    @GetMapping("/getSampleType")
    public List<String>getAllSampleType(){
        return sampleService.getSampleType();
    }


}
