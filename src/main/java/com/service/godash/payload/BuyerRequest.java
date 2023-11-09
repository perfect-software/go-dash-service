package com.service.godash.payload;

import lombok.Data;

import java.util.Date;

@Data
public class BuyerRequest {
    private String buyerName;
    private String buyerAbbriviation;
    private String buyerBillingAddress;
    private String buyerShippingAddress;
    private String buyerPhone;
    private String buyerMobile;
    private String buyerEmail;
    private String buyerCity;
    private String buyerState;
    private String buyerCountry;
    private String buyerPincode;
    private String buyerType;
    private String buyerContactPerson;
    private String merchendiser;
    private String currency;
    private String discount;
    private String paymentTerms;
    private String splDiscount;
    private String comments;
    private Date entDate;
    private BsAccountRequest bsAccountRequest;
//    private String bankName;
//    private String bankBranch;
//    private String bankAccountNo;
//    private String bankIFSC;
//    private String bankAccountType;
//    private String bankCity;
//    private String bankAddress;
//    private String bankSwiftCode;

}
