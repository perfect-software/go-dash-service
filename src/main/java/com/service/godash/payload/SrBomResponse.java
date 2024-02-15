package com.service.godash.payload;

import com.service.godash.model.SrBom;
import lombok.Data;

@Data
public class SrBomResponse {

    private Integer SampleId;

    private String srno;

    private String articleNo;

    private String buyerName;
}
