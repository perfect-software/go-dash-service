package com.service.godash.service.impl;

import com.service.godash.model.Supplier;
import com.service.godash.payload.MessageResponse;
import com.service.godash.payload.SupplierResponse;
import com.service.godash.repository.SupplierRepo;
import com.service.godash.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<SupplierResponse> getAllSupplier() throws Exception {
        try {
            List<Supplier> suppliers = supplierRepo.findAll();
            List<SupplierResponse> supplierResponses = new ArrayList<>();
            for (Supplier supplier : suppliers) {
                SupplierResponse response = new SupplierResponse();
                response.setSupplier_id(supplier.getSupplierId());
                response.setSupplierName(supplier.getSupplierName());
                supplierResponses.add(response);
            }
            return supplierResponses;
        } catch (Exception ex) {
            throw new Exception("Error retrieving buyers from the repository", ex);
        }
    }
}
