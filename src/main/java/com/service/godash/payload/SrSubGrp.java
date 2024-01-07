package com.service.godash.payload;

import lombok.Data;

import java.util.List;
@Data
public class SrSubGrp {
    private String itemsubgrp;
    private List<SrItem> items;

}
