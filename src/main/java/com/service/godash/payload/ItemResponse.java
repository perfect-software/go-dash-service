package com.service.godash.payload;

import com.service.godash.model.Item;
import lombok.Data;

@Data
public class ItemResponse {
    private Integer itemId;
    private String itemName;

    // Empty constructor (required by JPA)
    public ItemResponse() {
    }

    // Constructor with parameters
    public ItemResponse(Integer itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }
}
