package com.service.godash.service;

import com.service.godash.model.Item;
import com.service.godash.payload.ItemRequest;
import org.springframework.http.ResponseEntity;

public interface ItemService {

    ResponseEntity<?>  createItem(ItemRequest request) throws Exception;
}
