package com.service.godash.payload;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemRequest {
    @Column(name = "animal")
    private String animal;
    @Column(name = "season")
    private String season;
    @Column(name = "characteristics")
    private String characteristics;
    @Column(name = "texture")
    private String texture;
    @Column(name = "substance")
    private String substance;
    @Column(name = "tanning")
    private String tanning;
    @Column(name = "origin")
    private String origin;
    @Column(name = "tannery")
    private String tannery;
    @Column(name = "color")
    private String color;
    @Column(name = "uniquecode")
    private String uniquecode;
    @Column(name = "skintype")
    private String skintype;
    @Column(name = "size")
    private String size;
    @Column(name = "itemname")
    private String itemname;
}
