package com.service.godash.payload;

import lombok.Data;

@Data
public class BsAccountRequest {
    private String bankName;
    private String bankBranch;
    private String bankAccountNo;
    private String bankIFSC;
    private String bankAccountType;
    private String bankCity;
    private String bankAddress;
    private String bankSwiftCode;
}
