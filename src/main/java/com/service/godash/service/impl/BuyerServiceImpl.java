package com.service.godash.service.impl;

import com.service.godash.constants.IConstants;
import com.service.godash.model.BankAccount;
import com.service.godash.model.Buyer;
import com.service.godash.payload.BuyerRequest;
import com.service.godash.payload.BuyerResponse;
import com.service.godash.payload.MessageResponse;
import com.service.godash.repository.BsAccountRepo;
import com.service.godash.repository.BuyerRepo;
import com.service.godash.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
    public String createBuyer(BuyerRequest request) throws Exception {
        try {
            Buyer buyer = new Buyer(request);
            buyerRepo.save(buyer);
            createBankAccount(request, buyer);
            return buyer.getBsName();
        }
        catch(Exception ex){
           throw new Exception("Error creating buyer");
        }
    }

    private void createBankAccount(BuyerRequest request,Buyer buyer){
        BankAccount bankAccount=new BankAccount(request);
        bankAccount.setBusinessInd(IConstants.BUYER);
        bankAccount.setBusinessId(buyer.getBs_id());
        bsAccountRepo.save(bankAccount);
    }

    @Override
    public List<Buyer> getAllBuyer() {
        try {
            return buyerRepo.findAll();
        } catch (DataAccessException ex) {
            log.error("Error while retrieving buyers from the repository", ex);
            throw new RuntimeException("Error retrieving buyers from the repository", ex);
        }
    }

}
