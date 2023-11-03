package com.service.godash.payload;

import lombok.Data;

@Data
public class BuyerResponse {
    public BuyerResponse(int bsId,String bsName,String deliveryAddress) {
        this.bsId=bsId;
        this.bsName = bsName;
        this.deliveryAddress = deliveryAddress;
    }
    private int bsId;
    private String bsName;
    private String deliveryAddress;
}
