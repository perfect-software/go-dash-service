package com.service.godash.service;

import com.service.godash.model.Item;
import org.springframework.http.ResponseEntity;

public interface ItemService {

    ResponseEntity<?>  createItem(Item request) throws Exception;
}
