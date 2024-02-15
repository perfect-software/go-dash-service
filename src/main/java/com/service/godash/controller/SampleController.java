package com.service.godash.controller;

import com.service.godash.Exception.DuplicationException;
import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.*;
import com.service.godash.service.BuyerService;
import com.service.godash.service.SampleService;
import com.service.godash.util.Utility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @Autowired
    SampleService sampleService;
    @Autowired
    BuyerService buyerService;
    @Autowired
    Utility utility;

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> createSample(@Valid @RequestBody SampleRequest request, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse(errorMessage, HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        try {
            String srno=sampleService.createSampleRequest(request);
            ServiceResponse serviceResponse= ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Sample Request Created", HttpStatus.CREATED.value())).response(srno).build();
            return ResponseEntity.ok().body(serviceResponse);
        } catch (Exception ex) {
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while creating Sample Resquest", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }

    @GetMapping("/viewAllSample")
    public List<SampleResponse> viewAllSample() throws Exception {
        try {
            return sampleService.viewAllSampleRequest();
        } catch (Exception ex) {
            throw new Exception("Error while viewing sample");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> updateSampleRequest(@RequestBody SampleRequest request,BindingResult result) throws Exception {
        if (result.hasErrors()) {
            String errorMessage = result.getAllErrors().stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(", "));
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse(errorMessage, HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        try {
            String srno= sampleService.updateSampleRequest(request);
            ServiceResponse serviceResponse= ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Sample Request Updated", HttpStatus.CREATED.value())).response(srno).build();
            return ResponseEntity.ok().body(serviceResponse);
        }
        catch (DuplicationException ex){
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        catch (Exception ex) {
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while updating Sample Resquest", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }

    @GetMapping("/getBuyer")
    public List<BuyerResponse> getBuyer(@Valid @RequestParam String input){
        if (input.length() < 3) {
            return Collections.emptyList();
        }
        return buyerService.getBuyerByPartialName(input);

    }

    @GetMapping("/getAllBuyerByPage/{page_num}")
    public List<Buyer> getAllBuyer(@Valid @RequestParam int pageNum) {
       return buyerService.getBuyerByName(pageNum);
    }

    @GetMapping("/getAllBuyer")
    public List<Buyer> getAllBuyer() {
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
