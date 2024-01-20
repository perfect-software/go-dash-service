package com.service.godash.service;

import com.service.godash.model.Buyer;
import com.service.godash.model.Supplier;
import com.service.godash.payload.BuyerRequest;
import com.service.godash.payload.BuyerResponse;
import com.service.godash.payload.SupplierResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierService {

    ResponseEntity<?> createSupplier(Supplier supplierRequest);

//    List<BuyerResponse> getBuyerByPartialName(String partialName);
//
    List<Supplier> getSupplierByName(int page_num);

    List<SupplierResponse> getAllSupplier() throws Exception;
}
