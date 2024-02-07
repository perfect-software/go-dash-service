package com.service.godash.service.impl;

import com.service.godash.Exception.DuplicationException;
import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.SampleRequest;
import com.service.godash.payload.SampleResponse;
import com.service.godash.repository.*;
import com.service.godash.service.SampleService;
import com.service.godash.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public String createSampleRequest(SampleRequest request) throws Exception {
        Sample sample=new Sample(request);
        String finYear=getYear().substring(0,2);
        String srno=utility.generateSeqSRNO(finYear);
        sample.setSrno(srno);
        Buyer buyer=new Buyer();
            Buyer existingBuyer = buyerRepo.findByBsName(request.getBsName());
            if(existingBuyer!=null){
            buyer.setBs_id(existingBuyer.getBs_id());
            sample.setBuyer(buyer);
            sampleRequestRepo.save(sample);
            return srno;
        }
        else
            throw new Exception("Buyer does not exist. Enter existing buyer only.");
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
        List<Sample> resultList=sampleRequestRepo.findAllByOrderBySampleIdDesc();
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
            sampleResponse.setSr_no(item.getSrno());
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
            sampleResponse.setInternal_ref(item.getInternal_ref());
            sampleResponse.setLeather_remark(item.getLeather_remark());
            sampleResponse.setSole_remark(item.getSole_remark());
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

    public String updateSampleRequest(SampleRequest request) {
        Sample existingRequest= sampleRequestRepo.findById(request.getSample_id()).orElse(null);
        if (existingRequest!= null) {
            Sample sample=convertSampleToDTO(existingRequest,request);
            sampleRequestRepo.save(sample);
            return sample.getSrno();
        } else {
            throw new DuplicationException("Sample Request does not exist");
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

    private Sample convertSampleToDTO(Sample sample,SampleRequest request){
        sample.setSeason(request.getSeason());
        sample.setSampleRef(request.getSampleRef());
        sample.setSampleType(request.getSampleType());
        sample.setSampleRef(request.getSampleRef());
        sample.setArticle_no(request.getArticleNo());
        sample.setComments(request.getComments());
        sample.setBuyerArticle(request.getBuyerArticle());
        sample.setSize(request.getSize());
        sample.setQuantity(request.getQuantity());
        sample.setPair(request.getPair());
        sample.setUpperColor(request.getUpperColor());
        sample.setLiningColor(request.getLiningColor());
        sample.setLast(request.getLast());
        sample.setInsole(request.getInsole());
        sample.setSoleLabel(request.getSoleLabel());
        sample.setSocks(request.getSocks());
        sample.setHeel(request.getHeel());
        sample.setPattern(request.getPattern());
        sample.setBuyerRef(request.getBuyerRef());
        sample.setInUpperLeather(request.getInUpperLeather());
        sample.setInLining(request.getInLining());
        sample.setInSocks(request.getInSocks());
        sample.setInQuantity(request.getInQuantity());
        sample.setDeliveryDate(request.getDeliveryDate());
        sample.setProdExDate(request.getProdExDate());
        sample.setDateOfOrder(request.getDateOfOrder());
        sample.setImage_nm(request.getImage_nm());
        sample.setFinYear(request.getFinYear());
        sample.setInternal_ref(request.getInternal_ref());
        sample.setLeather_remark(request.getLeather_remark());
        sample.setSole_remark(request.getSole_remark());
        return sample;
    }

}
