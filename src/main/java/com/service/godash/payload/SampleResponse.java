package com.service.godash.payload;

import com.service.godash.model.Buyer;
import lombok.Data;

import java.util.Date;
@Data
public class SampleResponse {

    private int sampleId;

    private String sr_no;

    private String season;

    private String sampleRef;

    private String sampleType;

    private String articleNo;

    private String articleName;

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

    private Date dateOfOrder;

    private String finYear;

    private String image_nm;

//    @ManyToOne //defines many sample id against one buyer
//    @JoinColumn(name = "bs_id")
    private Buyer buyer;


}
