package com.service.godash.payload;

import lombok.Data;

import java.util.List;
@Data
public class SrBomRequest {
    private String sr_no;
    private String createdBy;
    private String bomType;
    private List<SrGrp> groups;
}
