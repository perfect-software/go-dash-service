package com.service.godash.service.impl;

import com.service.godash.model.*;
import com.service.godash.payload.*;
import com.service.godash.repository.*;
import com.service.godash.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    BOMRepo bomRepo;

    @Autowired
    SupplierRepo supplierRepo;

    @Autowired
    ItemQuotationRepo itemQuotationRepo;

    @Autowired
    ItemHeadRepo itemHeadRepo;
    @Autowired
    ItemGrpRepo itemGrpRepo;

    @Override
    public ResponseEntity<?> createItem(ItemRequest request) throws Exception {
        Item item = new Item(request);
        if (itemRepo.existsByitemname(item.getItemname())) {
            throw new Exception("Item already exists");
        }
        itemRepo.save(item);
        return ResponseEntity.ok("Item Created");
    }

    @Override
    public ResponseEntity<?> createItemHead(ItemHead request) {
        itemHeadRepo.save(request);
        return (ResponseEntity<?>) ResponseEntity.ok("Item Created");
    }

    @Override
    public List<ItemHead> getItemHead() {
        return itemHeadRepo.findAll();
    }

    @Override
    public List<ItemGrp> getItemGrpAndSubGrp() {
        return itemGrpRepo.findAll();
    }

    @Override
    public List<ItemResponse> getItemName() {

        return itemRepo.findItemName();
    }

    @Override
    public ResponseEntity<?> createItemQuotation(ItemQuotationRequest request) throws Exception {
        try {
            Item item = itemRepo.findByItemId(request.getItemId());
            Supplier supplier = supplierRepo.findBySupplierId(request.getSupplierId());
            ItemQuo itemQuo = new ItemQuo(request,item,supplier);
            itemQuotationRepo.save(itemQuo);
            return ResponseEntity.ok("Item Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while creating item");
        }
    }

    @Override
    public List<ItemQuotationResponse> getItemQuotation() throws Exception {
        List<ItemQuo> itemQuos = itemQuotationRepo.findAll();
        List<ItemQuotationResponse> itemQuotationResponses = new ArrayList<>();
        for (ItemQuo itemQuo : itemQuos) {
            ItemQuotationResponse itemQuotationResponse = new ItemQuotationResponse();
            itemQuotationResponse.setItem_quotation_id(itemQuo.getItem_quotation_id());
            itemQuotationResponse.setItemId(itemQuo.getItem().getItemId());
            itemQuotationResponse.setItemName(itemQuo.getItem().getItemname());
            itemQuotationResponse.setSupplierId(itemQuo.getSupplier().getSupplierId());
            itemQuotationResponse.setSupplierName(itemQuo.getSupplier().getSupplierName());
            itemQuotationResponse.setRate(itemQuo.getRate());
            itemQuotationResponse.setUnit(itemQuo.getUnit());
            itemQuotationResponse.setValidUntil(itemQuo.getValidUntil());
            itemQuotationResponses.add(itemQuotationResponse);

        }
        return itemQuotationResponses;
    }
}