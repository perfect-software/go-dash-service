package com.service.godash.service.impl;

import com.service.godash.model.BillOfMaterial;
import com.service.godash.payload.BomRequest;
import com.service.godash.repository.BOMRepo;
import com.service.godash.service.BomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BomServiceImpl implements BomService {

    @Autowired
    BOMRepo bomRepo;

    public ResponseEntity<?> createBom(BomRequest bom) {
        for (BomRequest.Group group : bom.getGroups()) {
            for (BomRequest.Subgroup subgroup : group.getSubgroups()) {
                for (BomRequest.Item item : subgroup.getItems()) {
                    BillOfMaterial srBOM = new BillOfMaterial();

                }
            }
        }
        return null;
    }
}
