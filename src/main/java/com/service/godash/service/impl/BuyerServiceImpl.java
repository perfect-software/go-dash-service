package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.repository.BuyerRepo;
import com.service.godash.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepo buyerRepo;
    @Override
    public List<String> getBuyerByPartialName(String partialName) {
        return  buyerRepo.findBsNameContainingIgnoreCase(partialName);
    }

    @Override
    public List<Buyer> getBuyerByName(String partialName) {
        return buyerRepo.findByBsNameContainingIgnoreCase(partialName);
    }
}
