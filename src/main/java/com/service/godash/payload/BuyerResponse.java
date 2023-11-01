package com.service.godash.payload;

import lombok.Data;

@Data
public class BuyerResponse {
    public BuyerResponse(String bsName,String deliveryAddress) {
        this.bsName = bsName;
        this.deliveryAddress = deliveryAddress;
    }

    private String bsName;
    private String deliveryAddress;
}
