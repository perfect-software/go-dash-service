package com.service.godash.payload;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class SampleRequest {


    private String season;
    private int sampleRef;
    private String sampleType;
    private String articleNo;
    private String buyerArticle;
    private String size;
    private String quantity;
    private String pair;
    private String upperColor;
    private String liningColor;
    private String last;
    private String insole;
    private String soleLabel;
    private String socks;
    private String heel;
    private String pattern;
    private String buyerRef;
    private String inUpperLeather;
    private String inLining;
    private String inSocks;
    private String inQuantity;
    private String comments;
    private Date deliveryDate;
    private Date prodExDate;
    private Date entDate;

}
