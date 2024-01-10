package com.service.godash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.godash.payload.BuyerRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="Buyer",schema = "ole")
public class Buyer {

    public Buyer(){
    }

//    public Buyer(BankAccount bsAccount) {
//        bankAccounts = new ArrayList<>();
//        bankAccounts.add(bsAccount);
//        // Initialize the bankAccounts list
//    }
    public Buyer(BuyerRequest request) {
//        this.code = request.getCode();
        this.bsName = request.getBuyerName();
        this.bsAbbreviation = request.getBuyerAbbriviation();
        this.billingAddress = request.getBuyerBillingAddress();
        this.deliveryAddress = request.getBuyerShippingAddress();
        this.city = request.getBuyerCity();
        this.pincode = request.getBuyerPincode();
        this.country = request.getBuyerCountry();
        this.currency = request.getCurrency();
//        this.bsCode = request.ge();
        this.contactPerson = request.getBuyerContactPerson();
//        this.mobileExt = request.getMobileExt();
        this.mobile = request.getBuyerMobile();
        this.phone = request.getBuyerPhone();
        this.email = request.getBuyerEmail();
//        this.username = request.getUsername();
//        this.entDate = request.getEntDate();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bs_id")
    private int bs_id;

    @Column(name = "Code")
    private String code;

    @Column(name = "bs_name")
    private String bsName;

    @Column(name = "bs_abbreviation")
    private String bsAbbreviation;

    @Column(name = "billing_addr")
    private String billingAddress;

    @Column(name = "delivery_addr")
    private String deliveryAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "country")
    private String country;

    @Column(name = "currency")
    private String currency;

    @Column(name = "bs_code")
    private String bsCode;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "mobile_ext")
    private String mobileExt;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "entDate")
    private Date entDate;

//    @OneToMany(mappedBy = "buyer")
//    @JsonIgnore
//    private List<BankAccount> bankAccounts;
}
