package com.service.godash.service.impl;

import com.service.godash.model.Item;
import com.service.godash.repository.ItemRepo;
import com.service.godash.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itemRepo;
    @Override
    public ResponseEntity<?> createItem(Item request) throws Exception {
        itemRepo.save(request);
        return ResponseEntity.ok("Item Created");
    }
}
