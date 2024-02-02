package com.service.godash.util;

import com.service.godash.payload.ResponseStatus;
import com.service.godash.repository.FinYearRepo;
import com.service.godash.repository.SampleRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utility {

    @Autowired
    FinYearRepo finYearRepo;

    @Autowired
    SampleRequestRepo sampleRequestRepo;

    public String generateSeqSRNO(String Year){
       Integer srno=(sampleRequestRepo.findCountSRNO(Year))+1;
        return String.format("%07d",srno)+"/"+Year;
    }

    public ResponseStatus getServiceResponse(String message,Integer code){
        ResponseStatus responseStatus=new ResponseStatus();
        responseStatus.setHttpStatus(code);
        responseStatus.setDescription(message);
        return responseStatus;
    }

}
