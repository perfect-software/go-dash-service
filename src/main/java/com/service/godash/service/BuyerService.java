package com.service.godash.service;

import com.service.godash.model.Buyer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BuyerService {
    List<String> getBuyerByPartialName(String partialName);

    List<Buyer> getBuyerByName(String partialName);
}
