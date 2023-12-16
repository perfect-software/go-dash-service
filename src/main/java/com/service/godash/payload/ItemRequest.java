package com.service.godash.payload;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NonNull;

@Data
public class ItemRequest {
    @NonNull
    private String itemgrp;
    @NonNull
    private String itemsubgrp;
    @NonNull
    private String animal;
    @NonNull
    private String season;
    @NonNull
    private String characteristics;
    @NonNull
    private String texture;
    @NonNull
    private String substance;
    @NonNull
    private String tanning;
    @NonNull
    private String origin;
    @NonNull
    private String tannery;
    @NonNull
    private String color;
    @NonNull
    private String uniquecode;
    @NonNull
    private String skintype;
    @NonNull
    private String size;
}
