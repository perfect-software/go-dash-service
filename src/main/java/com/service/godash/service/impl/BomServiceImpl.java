package com.service.godash.service.impl;

import com.service.godash.model.SrBom;
import com.service.godash.payload.SrBomRequest;
import com.service.godash.payload.SrGrp;
import com.service.godash.payload.SrItem;
import com.service.godash.payload.SrSubGrp;
import com.service.godash.repository.BOMRepo;
import com.service.godash.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BomServiceImpl implements BomService {

    @Autowired
    BOMRepo bomRepo;

    public ResponseEntity<?> createBom(SrBomRequest request){
        SrBom srBom = new SrBom();
        for (SrGrp group : request.getGroups()) {
            System.out.println("Group: " + group.getItemgrp());

            for (SrSubGrp subgroup : group.getSubgroups()) {
                System.out.println("\tSubgroup: " + subgroup.getItemsubgrp());

                for (SrItem item : subgroup.getItems()) {
                    srBom.setSample_id(request.getSample_id());
                    srBom.setItem_id(item.getItemId());
                    srBom.setUsedIn(item.getUsedIn());
                    srBom.setBomQty(item.getBomQty());
                    srBom.setPair(item.getPair());
                    srBom.setStockConsumedQty(item.getStockConsumedQty());
                    srBom.setItemSubGrp(subgroup.getItemsubgrp());
                    srBom.setItemGrp(group.getItemgrp());
                    srBom.setReqQty(item.getRequiredQty());
                    srBom.setRate(item.getRate());
                    srBom.setUnit(item.getUnit());
                    srBom.setSupplier_id(item.getSupplierId());
                }
            }
        }
        bomRepo.save(srBom);
        return ResponseEntity.ok("BOM Created");
    }
}
