package com.service.godash.payload;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemRequest {
    private String animal;
    private String season;
    private String characteristics;
    private String texture;
    private String substance;
    private String tanning;
    private String origin;
    private String tannery;
    private String color;
    private String uniquecode;
    private String skintype;
    private String size;
    private String itemname;
}
