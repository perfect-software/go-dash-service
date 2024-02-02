package com.service.godash.controller;

import com.service.godash.Exception.GenericException;
import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.*;
import com.service.godash.service.BuyerService;
import com.service.godash.service.SampleService;
import com.service.godash.util.Utility;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Provider;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
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


    private final Path rootLocation = Paths.get("D:/service/go-dash-images/");

    private final String imagePath="D:/service/go-dash-images/";


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

    @GetMapping("/view/{page_num}")
    public List<Sample> viewSample(@Valid @RequestParam int page_num) throws Exception {
        try {
            return sampleService.viewSampleRequest(page_num);
        } catch (Exception ex) {
            throw new Exception("Error while viewing sample");
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
            String fileName = UUID.randomUUID().toString().substring(0,20) + extension;
            Path directory = Paths.get(imagePath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            String filePath = imagePath + fileName;
            File dest = new File(filePath);
            file.transferTo(dest);
            return ResponseEntity.ok(new MessageResponse(fileName));
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
