package com.service.godash.payload;

import lombok.Data;

import java.util.List;
@Data
public class SrBomRequest {
    private Integer sample_id;
    private List<SrGrp> groups;
}
