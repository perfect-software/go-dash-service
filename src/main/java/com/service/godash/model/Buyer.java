package com.service.godash.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="Buyer",schema = "ole")
public class Buyer {
    @Id
    @Column(name = "bs_id")
    private int bsId;

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
}
