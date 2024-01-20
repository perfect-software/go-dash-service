package com.service.godash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.service.godash.payload.SupplierResponse;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "supplier",schema = "ole")
@Data
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "supplier_id")
    @JsonIgnore
    private int supplier_id;

    @Column(name = "Code")
    private String code;

    @Column(name = "supplier_name")
    private String supplierName;

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


    public Supplier(Supplier supplierRequest) {
        this.code = supplierRequest.getCode();
        this.supplierName = supplierRequest.getSupplierName();
        this.billingAddress = supplierRequest.getBillingAddress();
        this.deliveryAddress = supplierRequest.getDeliveryAddress();
        this.city = supplierRequest.getCity();
        this.pincode = supplierRequest.getPincode();
        this.country = supplierRequest.getCountry();
        this.currency = supplierRequest.getCurrency();
        this.contactPerson = supplierRequest.getContactPerson();
        this.mobileExt = supplierRequest.getMobileExt();
        this.mobile = supplierRequest.getMobile();
        this.phone = supplierRequest.getPhone();
        this.email = supplierRequest.getEmail();
    }

    public Supplier() {
    }

}
