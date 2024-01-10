package com.service.godash.model;

import com.service.godash.payload.BuyerRequest;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="BankAccount",schema = "ole")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int BankAccountId;

    @Column(name = "business_id")
    private int businessId;

    @Column(name = "bankName", length = 100)
    private String bankName;

    @Column(name = "bankBranch", length = 100)
    private String bankBranch;

    @Column(name = "bankAccountNo", length = 100)
    private String bankAccountNo;

    @Column(name = "bankIFSC", length = 100)
    private String bankIFSC;

    @Column(name = "bankAccountType", length = 100)
    private String bankAccountType;

    @Column(name = "bankCity", length = 100)
    private String bankCity;

    @Column(name = "bankAddress", length = 100)
    private String bankAddress;

    @Column(name = "bankSwiftCode", length = 100)
    private String bankSwiftCode;

    @Column(name = "businessInd", length = 100)
    private String businessInd;

    public BankAccount(BuyerRequest request) {
        this.bankName=request.getBsAccountRequest().getBankName();
        this.bankBranch=request.getBsAccountRequest().getBankBranch();
        this.bankAccountNo=request.getBsAccountRequest().getBankAccountNo();
        this.bankIFSC=request.getBsAccountRequest().getBankIFSC();
        this.bankAccountType=request.getBsAccountRequest().getBankAccountType();
        this.bankAddress=request.getBsAccountRequest().getBankAddress();
        this.bankCity=request.getBsAccountRequest().getBankCity();
        this.bankSwiftCode=request.getBsAccountRequest().getBankSwiftCode();
    }

    public BankAccount() {
    }
}
