package com.service.godash.service.impl;

import com.service.godash.model.SrBom;
import com.service.godash.model.Item;
import com.service.godash.model.ItemGrp;
import com.service.godash.model.ItemHead;
import com.service.godash.payload.ItemRequest;
import com.service.godash.repository.BOMRepo;
import com.service.godash.repository.ItemGrpRepo;
import com.service.godash.repository.ItemHeadRepo;
import com.service.godash.repository.ItemRepo;
import com.service.godash.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    BOMRepo bomRepo;

    @Autowired
    ItemHeadRepo itemHeadRepo;
    @Autowired
    ItemGrpRepo itemGrpRepo;
    @Override
    public ResponseEntity<?> createItem(ItemRequest request) throws Exception {
        Item item = new Item(request);
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
    public List<String> getItemName(String input) {
        return itemRepo.findItemNameContainingIgnoreCase(input);
    }

    @Override
    public ResponseEntity<?> createSampleBOM(SrBom request) {
        try {
            bomRepo.save(request);
            return ResponseEntity.ok("BOM Created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while creating BOM");
        }
    }

}
