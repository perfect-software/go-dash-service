package com.service.godash.service;

import com.service.godash.model.Item;
import com.service.godash.model.ItemHead;
import com.service.godash.payload.ItemRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<?>  createItem(ItemRequest request) throws Exception;

    ResponseEntity<?> createItemHead(ItemHead request);

    List<ItemHead>  getItemHead();
}
