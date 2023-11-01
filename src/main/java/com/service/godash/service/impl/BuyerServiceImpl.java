package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.payload.BuyerResponse;
import com.service.godash.repository.BuyerRepo;
import com.service.godash.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepo buyerRepo;
    @Override
    public List<BuyerResponse> getBuyerByPartialName(String partialName) {
        return  buyerRepo.findBsNameContainingIgnoreCase(partialName);
    }

    @Override
    public List<Buyer> getBuyerByName(int page_num) {
        Pageable pageable = PageRequest.of(page_num, 12);
        Page<Buyer> page = buyerRepo.findAll(pageable);
        List<Buyer> resultList = page.getContent();
        return resultList;
    }
}
