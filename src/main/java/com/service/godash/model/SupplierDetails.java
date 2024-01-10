package com.service.godash.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SupplierDetails")
public class SupplierDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierdetail_id")
    private int supplierDetailId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private Supplier supplier;

    @Column(name = "s_contact_person")
    private String contactPerson;

    @Column(name = "s_designation")
    private String designation;

    @Column(name = "s_mobile_no")
    private String mobileNumber;

    @Column(name = "msme")
    private String msme;

    @Column(name = "msme_no")
    private String msmeNumber;

    @Column(name = "ownership_type")
    private String ownershipType;

    @Column(name = "business_nature")
    private String businessNature;

    @Column(name = "estb_year")
    private String establishmentYear;

    @Column(name = "monthly_capacity")
    private String monthlyCapacity;

    @Column(name = "iso")
    private String iso;

    @Column(name = "lease_time_moq")
    private String leaseTimeMoq;

    @Column(name = "major_products")
    private String majorProducts;

    @Column(name = "payment_terms")
    private String paymentTerms;

    @Column(name = "gst_no")
    private String gstNumber;

    @Column(name = "registered_sa")
    private String registeredSa;

    @Column(name = "tsd_deduction")
    private String tsdDeduction;


}
