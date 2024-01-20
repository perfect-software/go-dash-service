package com.service.godash.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ItemQuotationRequest {
    @NotNull(message = "Item Id is required")
    private Integer ItemId;
    @NotNull(message = "Supplier Id is required")
    private Integer SupplierId;
    private Double Rate;
    private String Unit;
    private Date ValidUntil;
}
