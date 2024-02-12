package com.service.godash.controller;

import com.service.godash.model.Buyer;
import com.service.godash.payload.BuyerRequest;
import com.service.godash.payload.SampleRequest;
import com.service.godash.payload.ServiceResponse;
import com.service.godash.service.BuyerService;
import com.service.godash.util.Utility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @Autowired
    Utility utility;

    @PostMapping("/create")
    public ResponseEntity<?> createBuyer(@Valid @RequestBody BuyerRequest request) throws Exception {
        try {
            String buyerName = buyerService.createBuyer(request);
            ServiceResponse serviceResponse = ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Buyer Created", HttpStatus.CREATED.value())).response(buyerName).build();
            return ResponseEntity.ok().body(serviceResponse);
        }
        catch (Exception ex){
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while creating Buyer", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }
}
