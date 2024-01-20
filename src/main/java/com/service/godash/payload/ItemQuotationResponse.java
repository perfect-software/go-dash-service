package com.service.godash.payload;

import lombok.Data;

import java.util.Date;

@Data
public class ItemQuotationResponse {

    private Integer item_quotation_id;
    private Integer ItemId;
    private String itemName;
    private Integer SupplierId;
    private String supplierName;
    private Double Rate;
    private String Unit;
    private Date ValidUntil;
}
