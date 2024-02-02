package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SampleRequest;
import com.service.godash.payload.SampleResponse;
import com.service.godash.repository.*;
import com.service.godash.service.SampleService;
import com.service.godash.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.Year;
import java.util.ArrayList;
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

    @Autowired
    ArticleRepo articleRepo;
    @Autowired
    Utility utility;


    @Override
    public ResponseEntity<?> createSampleRequest(SampleRequest request) {
        Sample sample=new Sample(request);
        String finYear=getYear().substring(0,2);
        String srno=utility.generateSeqSRNO(finYear);
        sample.setSr_no(srno);
        Buyer buyer=new Buyer();
            Buyer existingBuyer = buyerRepo.findByBsName(request.getBsName());
            if(existingBuyer!=null){
            buyer.setBs_id(existingBuyer.getBs_id());
            sample.setBuyer(buyer);
            sampleRequestRepo.save(sample);
            return ResponseEntity.ok(new MessageResponse("Sample Request Created"));
        }
        else
            return ResponseEntity.ok(new MessageResponse(("Enter existing buyer only")));
    }

    @Override
    public List<Sample> viewSampleRequest(int page_num) {
        Pageable pageable = PageRequest.of(page_num, 12);
        Page<Sample> page = sampleRequestRepo.findAll(pageable);
        List<Sample> resultList = page.getContent();
        return resultList;
    }

    @Override
    public List<SampleResponse> viewAllSampleRequest() {
        List<SampleResponse> sampleResponseList=new ArrayList<>();
        List<Sample> resultList=sampleRequestRepo.findAllByOrderByentDateDesc();
        for(Sample item: resultList){
            SampleResponse sampleResponse=new SampleResponse();
            String articleName=articleRepo.findArticleName(Integer.parseInt(item.getArticle_no()));
            sampleResponse.setSampleId(item.getSampleId());
            sampleResponse.setSampleRef(item.getSampleRef());
            sampleResponse.setArticleNo(item.getArticle_no());
            sampleResponse.setArticleName(articleName);
            sampleResponse.setBuyerArticle(item.getBuyerArticle());
            sampleResponse.setBuyerRef(item.getBuyerRef());
            sampleResponse.setHeel(item.getHeel());
            sampleResponse.setInSocks(item.getInSocks());
            sampleResponse.setInLining(item.getInLining());
            sampleResponse.setComments(item.getComments());
            sampleResponse.setDateOfOrder(item.getDateOfOrder());
            sampleResponse.setLast(item.getLast());
            sampleResponse.setInQuantity(item.getInQuantity());
            sampleResponse.setInsole(item.getInsole());
            sampleResponse.setDeliveryDate(item.getDeliveryDate());
            sampleResponse.setInUpperLeather(item.getInUpperLeather());
            sampleResponse.setSampleType(item.getSampleType());
            sampleResponse.setSr_no(item.getSr_no());
            sampleResponse.setPair(item.getPair());
            sampleResponse.setLiningColor(item.getLiningColor());
            sampleResponse.setProdExDate(item.getProdExDate());
            sampleResponse.setQuantity(item.getQuantity());
            sampleResponse.setPattern(item.getPattern());
            sampleResponse.setSeason(item.getSeason());
            sampleResponse.setSoleLabel(item.getSoleLabel());
            sampleResponse.setUpperColor(item.getUpperColor());
            sampleResponse.setSize(item.getSize());
            sampleResponse.setFinYear(item.getFinYear());
            sampleResponse.setImage_nm(item.getImage_nm());
            sampleResponse.setSocks(item.getSocks());
            if (item.getBuyer() != null) {
                Buyer buyer = item.getBuyer();
                Buyer buyerDto = new Buyer();
                buyerDto.setBs_id(buyer.getBs_id());
                buyerDto.setCode(buyer.getCode());
                buyerDto.setBsName(buyer.getBsName());
                buyerDto.setBsAbbreviation(buyer.getBsAbbreviation());
                buyerDto.setCity(buyer.getCity());
                buyerDto.setPincode(buyer.getPincode());
                buyerDto.setCountry(buyer.getCountry());
                buyerDto.setBsCode(buyer.getBsCode());
                buyerDto.setContactPerson(buyer.getContactPerson());
                buyerDto.setMobileExt(buyer.getMobileExt());
                buyerDto.setMobile(buyer.getMobile());
                buyerDto.setPhone(buyer.getPhone());
                buyerDto.setEmail(buyer.getEmail());
                buyerDto.setUsername(buyer.getUsername());
                buyerDto.setEntDate(buyer.getEntDate());
                buyerDto.setBillingAddress(buyer.getBillingAddress());
                buyerDto.setDeliveryAddress(buyer.getDeliveryAddress());
                sampleResponse.setBuyer(buyerDto);
            }
            sampleResponseList.add(sampleResponse);
        }
        return sampleResponseList;
    }

    public ResponseEntity<?> updateSampleRequest(SampleRequest request) {
        Sample existingRequest = sampleRequestRepo.findById(request.getSample_id()).orElse(null);
        if (existingRequest != null) {
            // Update the fields as needed
            //cannot update buyer
            existingRequest.setSeason(request.getSeason());
            existingRequest.setSampleRef(request.getSampleRef());
            existingRequest.setSampleType(request.getSampleType());
            existingRequest.setSampleRef(request.getSampleRef());
            existingRequest.setArticle_no(request.getArticleNo());
            existingRequest.setComments(request.getComments());
            existingRequest.setBuyerArticle(request.getBuyerArticle());
            existingRequest.setSize(request.getSize());
            existingRequest.setQuantity(request.getQuantity());
            existingRequest.setPair(request.getPair());
            existingRequest.setUpperColor(request.getUpperColor());
            existingRequest.setLiningColor(request.getLiningColor());
            existingRequest.setLast(request.getLast());
            existingRequest.setInsole(request.getInsole());
            existingRequest.setSoleLabel(request.getSoleLabel());
            existingRequest.setSocks(request.getSocks());
            existingRequest.setHeel(request.getHeel());
            existingRequest.setPattern(request.getPattern());
            existingRequest.setBuyerRef(request.getBuyerRef());
            existingRequest.setInUpperLeather(request.getInUpperLeather());
            existingRequest.setInLining(request.getInLining());
            existingRequest.setInSocks(request.getInSocks());
            existingRequest.setInQuantity(request.getInQuantity());
            existingRequest.setDeliveryDate(request.getDeliveryDate());
            existingRequest.setProdExDate(request.getProdExDate());
            existingRequest.setDateOfOrder(request.getDateOfOrder());
            existingRequest.setImage_nm(request.getImage_nm());
            existingRequest.setFinYear(request.getFinYear());
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
    public List<String> getSampleType() {
        return sampleTypeRepo.findAllType();
    }

    @Autowired
    FinYearRepo finYearRepo;

    public String getYear(){
        String year=finYearRepo.findyear();
        return year;
    }

}
