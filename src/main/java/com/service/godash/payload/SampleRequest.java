package com.service.godash.payload;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
public class SampleRequest {

    private int sample_id;
    @Size(max=60,message = "buyer name exceeding char limit")
    private String bsName;
    @Size(max=20,message = "sample type exceeding char limit")
    private String sampleType;
    @Size(max=10,message = "season exceeding char limit")
    private String season;
    @Size(max=30,message = "sample ref exceeding char limit")
    private String sampleRef;
    @Size(max=10,message = "article no exceeding char limit")
    private String articleNo;
    private Date entDate;
    @Size(max=50,message = "buyer article exceeding char limit")
    private String buyerArticle;
    @Size(max=5,message = "size exceeding char limit")
    private String buyerRef;
    @Size(max=50,message = "inUpperLeather exceeding char limit")
    private String size;
    @Size(max=5,message = "quantity exceeding char limit")
    private String quantity;
    @Size(max=5,message = "pair exceeding char limit")
    private String pair;
    @Size(max=20,message = "upper color exceeding char limit")
    private String upperColor;
    @Size(max=20,message = "lining color exceeding char limit")
    private String liningColor;
    @Size(max=20,message = "last exceeding char limit")
    private String last;
    @Size(max=20,message = "insole exceeding char limit")
    private String insole;
    @Size(max=20,message = "sole label exceeding char limit")
    private String soleLabel;
    @Size(max=20,message = "socks exceeding char limit")
    private String socks;
    @Size(max=20,message = "heel exceeding char limit")
    private String heel;
    @Size(max=20,message = "pattern exceeding char limit")
    private String pattern;
    @Size(max=50,message = "buyer ref exceeding char limit")
    private String inUpperLeather;
    @Size(max=50,message = "inlining exceeding char limit")
    private String inLining;
    @Size(max=50,message = "inSocks exceeding char limit")
    private String inSocks;
    @Size(max=50,message = "inQuantity exceeding char limit")
    private String inQuantity;
    @Size(max=200,message = "Comment exceeding char limit")
    private String comments;
    private Date deliveryDate;
    private Date prodExDate;
    private Date dateOfOrder;
    @Size(max=5,message = "finyear exceeding char limit")
    private String finYear;
    @Size(max=200,message = "image exceeding char limit")
    private String image_nm;

}
