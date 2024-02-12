package com.service.godash.controller;

import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.ServiceResponse;
import com.service.godash.payload.SrBomRequest;
import com.service.godash.service.BomService;
import com.service.godash.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bom")
public class BomController {
    @Autowired
    BomService bomService;

    @Autowired
    Utility utility;

    @PostMapping("/create")
    private ResponseEntity<ServiceResponse> createBom(@RequestBody SrBomRequest request){
        try {
            String srno=bomService.createBom(request);
            ServiceResponse serviceResponse= ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("SR Bom Created", HttpStatus.CREATED.value())).response(srno).build();
            return ResponseEntity.ok().body(serviceResponse);
        }
        catch(Exception ex) {
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while creating SR BOM", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }
}
