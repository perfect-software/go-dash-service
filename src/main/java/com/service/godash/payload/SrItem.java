package com.service.godash.payload;

import com.service.godash.model.Supplier;
import lombok.Data;

@Data
public class SrItem {
    private Integer itemId;
    private String usedIn;
    private String pair;
    private Double bomQty;
    private Double stockConsumedQty;
    private Double requiredQty;
    private Double rate;
    private String unit;
    private Integer supplierId;

}
