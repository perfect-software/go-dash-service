package com.service.godash.controller;

import com.service.godash.model.BillOfMaterial;
import com.service.godash.model.Item;
import com.service.godash.model.ItemGrp;
import com.service.godash.model.ItemHead;
import com.service.godash.payload.ItemGrpAndSubGrp;
import com.service.godash.payload.ItemRequest;
import com.service.godash.payload.SampleRequest;
import com.service.godash.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<?> createItem(@Valid @RequestBody ItemRequest request) throws Exception {
        return itemService.createItem(request);

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
    public List<String> getItemName(String input) throws Exception {
        return itemService.getItemName(input);
    }
//    @PostMapping("/createSampleBOM")
//    public ResponseEntity<?> createSampleBOM (List<BillOfMaterial> request) throws Exception {
//      try {
//          request.forEach(billOfMaterial -> {
//              itemService.createSampleBOM(billOfMaterial);
//          });
//          return ResponseEntity.ok("BOM Created");
//      } catch (Exception ex) {
//          return ResponseEntity.badRequest().body("Error while creating BOM: " + ex.getMessage());
//      }
//    }
    
}
