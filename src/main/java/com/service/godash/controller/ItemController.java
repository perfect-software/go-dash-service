package com.service.godash.controller;

import com.service.godash.model.ItemGrp;
import com.service.godash.model.ItemHead;
import com.service.godash.model.ItemQuo;
import com.service.godash.payload.ItemRequest;
import com.service.godash.payload.ItemResponse;
import com.service.godash.payload.MessageResponse;
import com.service.godash.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<?> createItem(@Valid @RequestBody ItemRequest request) throws Exception {
        try {
            itemService.createItem(request);
            return ResponseEntity.ok().body(new MessageResponse("Item Created"));
        }
        catch(Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error while creating item: " + ex.getMessage()));
        }

    }

    @PostMapping("/createItemHead")
    public ResponseEntity<?> createItemHead(@Valid @RequestBody ItemHead request) throws Exception {
        return itemService.createItemHead(request);

    }

    @GetMapping("/getItemHead")
    public List<ItemHead> getItemHead() throws Exception {
        return itemService.getItemHead();
    }
    @GetMapping("/getItemGrpAndSubGrp")
    public List<ItemGrp> getItemGrpAndSubGrp() throws Exception {
        return itemService.getItemGrpAndSubGrp();
    }

    @GetMapping("/getItemName")
    public List<ItemResponse> getItemName(String input) throws Exception {
        return itemService.getItemName(input);
    }

    @PostMapping("/createItemQuotation")
    public ResponseEntity<?> createItemQuotation(@Valid @RequestBody ItemQuo request) throws Exception {
        try {
            itemService.createItemQuotation(request);
            return ResponseEntity.ok().body(new MessageResponse("Item Created"));
        }
        catch(Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error while creating item: " + ex.getMessage()));
        }

    }

    @GetMapping("/getItemQuotation")
    public List<ItemQuo> getItemQuotation() throws Exception {
        return itemService.getItemQuotation();
    }
}
