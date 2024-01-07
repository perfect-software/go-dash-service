package com.service.godash.service;

import com.service.godash.model.SrBom;
import com.service.godash.model.ItemGrp;
import com.service.godash.model.ItemHead;
import com.service.godash.payload.ItemRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<?>  createItem(ItemRequest request) throws Exception;

    ResponseEntity<?> createItemHead(ItemHead request);

    List<ItemHead>  getItemHead();

    List<ItemGrp> getItemGrpAndSubGrp();

    List<String> getItemName(String input);

    ResponseEntity<?>createSampleBOM (SrBom request);
}
