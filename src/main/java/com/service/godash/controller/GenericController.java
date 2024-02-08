package com.service.godash.controller;

import com.service.godash.model.Sample;
import com.service.godash.payload.ServiceResponse;
import com.service.godash.repository.SampleRequestRepo;
import com.service.godash.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import static com.service.godash.constants.IConstants.imagePathArticleDir;
import static com.service.godash.constants.IConstants.imagePathSampleRequestDir;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/generic")
public class GenericController {
    @Autowired
    private Utility utility;

    @Autowired
    private SampleRequestRepo sampleRequestRepo;

    @PostMapping("/upload")
    public ResponseEntity<ServiceResponse> handleImageUpload(@RequestParam("image") MultipartFile file, @RequestParam("fileName") String fileName, @RequestParam("type") String type) {
        String imagePath="";
        if (file.isEmpty()) {
            ServiceResponse serviceResponse=ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("No file uploaded", HttpStatus.BAD_REQUEST.value())).build();
            return ResponseEntity.badRequest().body(serviceResponse);
        } else if (file.getSize() > 1000000) {
            ServiceResponse serviceResponse = ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("File size should be less than 1MB", HttpStatus.BAD_REQUEST.value()))
                    .build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        try {
            String originalName = file.getOriginalFilename();
            String extension = originalName.substring(originalName.lastIndexOf("."));
            String newFileName = fileName.replaceAll("/", "_");
            String fileNameWithExtention = newFileName + extension;
            if (type.equalsIgnoreCase("sample")) {
                if(sampleRequestRepo.findBySrno(fileName)!=null) {
                    Sample sample = sampleRequestRepo.findBySrno(fileName);
                    sample.setImage_nm(fileNameWithExtention);
                    sampleRequestRepo.save(sample);
                }
                else {
                    throw new SQLException("No such SR NO exists!");
                }
            }
            if (type.equalsIgnoreCase("article")) {
                imagePath = imagePathArticleDir;
            } else if (type.equalsIgnoreCase("sample")) {
                imagePath = imagePathSampleRequestDir;
            }
            Path directory = Paths.get(imagePath);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }
            String filePath = imagePath + fileNameWithExtention;
            File dest = new File(filePath);
            file.transferTo(dest);
            ServiceResponse serviceResponse = ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Image uploaded successfully", HttpStatus.CREATED.value()))
                    .response(fileNameWithExtention)
                    .build();
            return ResponseEntity.status(HttpStatus.CREATED).body(serviceResponse);
        }catch (SQLException ex){
            ServiceResponse serviceResponse = ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value()))
                    .build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
        catch (Exception e) {
            ServiceResponse serviceResponse = ServiceResponse.builder()
                    .responseStatus(this.utility.getServiceResponse("Error while uploading image", HttpStatus.BAD_REQUEST.value()))
                    .build();
            return ResponseEntity.badRequest().body(serviceResponse);
        }
    }


    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename, @RequestParam("type") String type) {
        try {
            Path rootLocation = null;
            if(type.equalsIgnoreCase("article")) {
                rootLocation = Paths.get(imagePathArticleDir);
            }
            else if(type.equalsIgnoreCase("sample")) {
                rootLocation = Paths.get(imagePathSampleRequestDir);
            }
            Path file = rootLocation.resolve(filename).normalize().toAbsolutePath();
            System.out.println("Resolved file path: " + file.toString());

            if (!file.toFile().exists()) {
                return ResponseEntity.notFound().build();
            }
            Resource resource = new UrlResource(file.toUri());
            if (!resource.exists() || !resource.isReadable()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(resource);
        } catch (Exception e) {
            // Log any exceptions that occur
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }




}
