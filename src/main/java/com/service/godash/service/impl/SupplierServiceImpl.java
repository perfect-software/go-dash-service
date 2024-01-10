package com.service.godash.service.impl;

import com.service.godash.model.Buyer;
import com.service.godash.model.Supplier;
import com.service.godash.payload.MessageResponse;
import com.service.godash.repository.SupplierRepo;
import com.service.godash.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepo supplierRepo;
    @Override
    public ResponseEntity<?> createSupplier(Supplier supplierRequest) {
        Supplier supplier = new Supplier(supplierRequest);
        supplierRepo.save(supplier);
        return ResponseEntity.ok(new MessageResponse("Supplier Created"));
    }

    @Override
    public List<Supplier> getSupplierByName(int page_num) {
        Pageable pageable = PageRequest.of(page_num, 12);
        Page<Supplier> page = supplierRepo.findAll(pageable);
        List<Supplier> resultList = page.getContent();
        return resultList;
    }

    @Override
    public List<Supplier> getAllSupplier() throws Exception {
        try {
            return supplierRepo.findAll();
        } catch (Exception ex) {
            throw new Exception("Error retrieving buyers from the repository", ex);
        }
    }
}
