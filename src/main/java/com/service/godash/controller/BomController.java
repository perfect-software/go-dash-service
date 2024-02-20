package com.service.godash.controller;

import com.service.godash.model.SrBom;
import com.service.godash.model.SrBomDetails;
import com.service.godash.payload.*;
import com.service.godash.service.BomService;
import com.service.godash.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getSrNoList")
    public List<String> getSrNoList(){
        List<String> srnoList=bomService.getSRNO();
        return srnoList;
    }

    @GetMapping("/getSamplebySrNo")
    public SrBomResponse getSamplebySrno(@RequestParam String srno) throws Exception {
        try {
            return bomService.getSamplebySrno(srno);
        } catch (Exception ex) {
            throw new Exception("Error while viewing sample");
        }
    }

    @GetMapping("/viewSRBOM")
    public List<SrBom> viewAllSRBOM() throws Exception {
        try{
           return bomService.viewSRBOM();
        }
        catch (Exception ex){
            throw new Exception("Error while viewing sample");
        }
    }

    @GetMapping("/viewbomdetails")
    public List<SrBomDetails> viewAllBomDetails(Integer bomId) throws Exception{
        try{
            return bomService.getSrBomDetails(bomId);
        }
        catch (Exception ex){
            throw new Exception("Error view bom details");
        }
    }
}
