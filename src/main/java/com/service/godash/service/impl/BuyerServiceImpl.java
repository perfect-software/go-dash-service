package com.service.godash.service.impl;

import com.service.godash.model.BsAccount;
import com.service.godash.model.Buyer;
import com.service.godash.model.Sample;
import com.service.godash.payload.BuyerRequest;
import com.service.godash.payload.BuyerResponse;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SampleRequest;
import com.service.godash.repository.BsAccountRepo;
import com.service.godash.repository.BuyerRepo;
import com.service.godash.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    BuyerRepo buyerRepo;
    @Autowired
    BsAccountRepo bsAccountRepo;
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

    @Override
    public ResponseEntity<?> createBuyer(BuyerRequest request) {
        BsAccount bankAccount=new BsAccount(request);
        Buyer buyer=new Buyer(request);
        new Buyer(bankAccount);
        bankAccount.setBuyer(buyer);
//        buyer.getBankAccounts().add(bankAccount);
        buyerRepo.save(buyer);
        bsAccountRepo.save(bankAccount);
        return ResponseEntity.ok(new MessageResponse("Buyer Created"));
    }

}
