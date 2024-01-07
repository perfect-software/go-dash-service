package com.service.godash.payload;

import lombok.Data;

import java.util.List;
@Data
public class SrGrp {
    private String itemgrp;
    private List<SrSubGrp> subgroups;

}
