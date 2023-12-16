package com.service.godash.model;

import com.service.godash.payload.ItemRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Entity
@Data
@Table(name = "item", schema = "ole")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int item_id;
    @Column(name="item_grp")
    private String itemgrp;
    @Column(name = "item_sub_grp")
    private String itemsubgrp;
    @Column(name = "animal")
    private String animal;
    @Column (name = "season")
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

    public Item(ItemRequest request){
        this.itemgrp= request.getItemgrp();
        this.itemsubgrp=request.getItemsubgrp();
        this.animal=request.getAnimal();
        this.season=request.getSeason();
        this.characteristics=request.getCharacteristics();
        this.texture=request.getTexture();
        this.substance=request.getSubstance();
        this.tanning=request.getTanning();
        this.origin=request.getOrigin();
        this.tannery=request.getTannery();
        this.color=request.getColor();
        this.uniquecode=request.getUniquecode();
        this.skintype=request.getSkintype();
        this.size=request.getSize();
        this.itemname=this.animal+" "+this.characteristics+" "+this.texture+" "+
        this.substance+" "+this.tanning+" " +this.origin+" "+this.tannery+" "+
        this.color+" "+this.skintype+" "+this.uniquecode;
    }

}
