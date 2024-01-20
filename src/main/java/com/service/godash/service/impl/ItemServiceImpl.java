package com.service.godash.service.impl;

import com.service.godash.model.*;
import com.service.godash.payload.ItemQuotationResponse;
import com.service.godash.payload.ItemRequest;
import com.service.godash.payload.ItemResponse;
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
    public List<ItemResponse> getItemName(String input) {

        return itemRepo.findItemNameContainingIgnoreCase(input);
    }

    @Override
    public ResponseEntity<?> createItemQuotation(ItemQuo request) throws Exception {
        try {
            itemQuotationRepo.save(request);
            return ResponseEntity.ok("Item Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while creating item");
        }
    }

    @Override
    public List<ItemQuotationResponse> getItemQuotation() throws Exception {
        List<ItemQuo> itemQuos = itemQuotationRepo.findAll();
        List<ItemQuotationResponse> itemQuotationResponses = new ArrayList<>();
        ItemQuotationResponse itemQuotationResponse = new ItemQuotationResponse();
        for (ItemQuo itemQuo : itemQuos) {
            itemQuotationResponse.setItem_quotation_id(itemQuo.getItem_quotation_id());
            itemQuotationResponse.setItemName(itemQuo.getItem().getItemname());
            itemQuotationResponse.setSupplierName(itemQuo.getSupplier().getSupplierName());
            itemQuotationResponse.setRate(itemQuo.getRate());
            itemQuotationResponse.setUnit(itemQuo.getUnit());
            itemQuotationResponse.setValidUntil(itemQuo.getValidUntil());
            itemQuotationResponses.add(itemQuotationResponse);

        }
        return itemQuotationResponses;
    }
}