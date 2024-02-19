package com.service.godash.service.impl;

import com.service.godash.model.Sample;
import com.service.godash.model.SrBom;
import com.service.godash.model.SrBomDetails;
import com.service.godash.payload.*;
import com.service.godash.repository.ArticleRepo;
import com.service.godash.repository.SampleRequestRepo;
import com.service.godash.repository.SrBomDetailsRepo;
import com.service.godash.repository.SrBomRepo;
import com.service.godash.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BomServiceImpl implements BomService {

    @Autowired
    SrBomRepo srBomRepo;

    @Autowired
    SrBomDetailsRepo srBomDetailsRepo;

    @Autowired
    SampleRequestRepo sampleRequestRepo;

    @Autowired
    ArticleRepo articleRepo;

    public String createBom(SrBomRequest request){
        SrBom srBom=new SrBom();
        srBom.setSrno(request.getSr_no());
        srBom.setBomType(request.getBomType());
        srBom.setBomStatus("S");
        srBom.setCreatedBy(request.getCreatedBy());
        srBomRepo.save(srBom);
        Integer bomId=srBom.getBomId();
        for (SrGrp group : request.getGroups()) {
            System.out.println("Group: " + group.getItemgrp());
            for (SrSubGrp subgroup : group.getSubgroups()) {
                System.out.println("\tSubgroup: " + subgroup.getItemsubgrp());
                for (SrItem item : subgroup.getItems()) {
                    SrBomDetails srBomDetails=new SrBomDetails();
                    srBomDetails.setBomId(bomId);
                    srBomDetails.setItem_id(item.getItemId());
                    srBomDetails.setUsedIn(item.getUsedIn());
                    srBomDetails.setBomQty(item.getBomQty());
                    srBomDetails.setPair(item.getPair());
                    srBomDetails.setUnit(item.getUnit());
                    srBomDetails.setRate(item.getRate());
                    srBomDetails.setReqQty(item.getRequiredQty());
                    srBomDetails.setSupplier_id(item.getSupplierId());
                    srBomDetails.setItemGrp(group.getItemgrp());
                    srBomDetails.setItemSubGrp(subgroup.getItemsubgrp());
                    srBomDetails.setStockConsumedQty(item.getStockConsumedQty());
                    srBomDetails.setEntDate(LocalDateTime.now());
                    srBomDetailsRepo.save(srBomDetails);
                }
            }
        }
        String srno=request.getSr_no();
        return srno;
    }

    @Override
    public List<String> getSRNO() {
        return sampleRequestRepo.findSrno();
    }

    @Override
    public List<SrBom> viewSRBOM() {
        return srBomRepo.findAll();
    }

    @Override
    public SrBomResponse getSamplebySrno(String srno) {
        SrBomResponse srBomResponse=new SrBomResponse();
        Sample sample=sampleRequestRepo.findBySrno(srno);
        srBomResponse.setSrno(sample.getSrno());
        srBomResponse.setBuyerName(sample.getBuyer().getBsName());
        Integer articleId= Integer.valueOf(sample.getArticle_no());
        String articleNo = articleRepo.findArticleName(articleId);
        srBomResponse.setArticleNo(articleNo);
        srBomResponse.setSampleId(sample.getSampleId());
        return srBomResponse;
    }

    @Override
    public SrBomDetails getSrBomDetails(Integer bomId) {
        return srBomDetailsRepo.findBybomId(bomId);
    }

}
