package com.service.godash.service;

import com.service.godash.model.Buyer;
import com.service.godash.payload.BuyerResponse;

import java.util.List;

public interface BuyerService {
    List<BuyerResponse> getBuyerByPartialName(String partialName);

    List<Buyer> getBuyerByName(int page_num);
}
