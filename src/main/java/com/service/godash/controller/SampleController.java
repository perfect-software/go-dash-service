package com.service.godash.controller;

import com.service.godash.Exception.GenericException;
import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.*;
import com.service.godash.service.BuyerService;
import com.service.godash.service.SampleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @Autowired
    SampleService sampleService;
    @Autowired
    BuyerService buyerService;


    private final Path rootLocation = Paths.get("E:/service/go-dash-images/");


    @PostMapping("/create")
    public ResponseEntity<?> createSample(@Valid @RequestBody SampleRequest request) throws Exception {
        try {
            sampleService.createSampleRequest(request);
            return ResponseEntity.ok(new MessageResponse("Sample Created"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error while creating sample: " + ex.getMessage()));
        }
    }

    @GetMapping("/view/{page_num}")
    public List<Sample> viewSample(@Valid @RequestParam int page_num) throws Exception {
        try {
            return sampleService.viewSampleRequest(page_num);
        } catch (Exception ex) {
            throw new Exception("Error while viewing sample");
        }
    }

    @GetMapping("/viewAllSample")
    public List<Sample> viewAllSample() throws Exception {
        try {
            return sampleService.viewAllSampleRequest();
        } catch (Exception ex) {
            throw new Exception("Error while viewing sample");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSampleRequest(@RequestBody SampleRequest request) {
        try {
            return sampleService.updateSampleRequest(request);
        } catch (Exception e) {
            new GenericException("Error while updating sample", 500);
            return ResponseEntity.badRequest().body(new MessageResponse("Error while updating sample: " + e.getMessage()));
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

    @PostMapping("/upload")
    public ResponseEntity<?> handleImageUpload(@RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(new MessageResponse("No file uploaded."));
        }
        try {
            String originalName = file.getOriginalFilename();
            String extension = originalName.substring(originalName.lastIndexOf("."));
            String fileName = UUID.randomUUID().toString() + extension;
            String filePath = rootLocation + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);

            return ResponseEntity.ok(new MessageResponse(filePath));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error while uploading image: " + e.getMessage()));
        }
    }


    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path file = rootLocation.resolve(filename).normalize().toAbsolutePath();
            if (!file.toFile().exists()) {
                return ResponseEntity.notFound().build();
            }
            Resource resource = new UrlResource(file.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(resource);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }


}
