package com.service.godash.payload;

import lombok.Data;
import java.util.List;

@Data
public class BomRequest {
    @Data
    public class Group {
        private String itemgrp;
        private List<Subgroup> subgroups;

        // Getters and setters
    }
@Data
    public class Subgroup {
        private String itemsubgrp;
        private List<Item> items;

    }
    @Data
    public class Item {
        private String itemName;
        private String usedIn;
        private String pair;
        private String bomQty;
        private String requiredQty;
        private String cost;
        private String rate;
    }

    private Integer sampleId;
        private Integer articleNo;
        private String buyerName;
        private String articleName;
        private String color;
        private String animal;
        private String sole;
        private String totalCost;
        private List<Group> groups;


}
