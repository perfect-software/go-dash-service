package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="SR_BOM",schema = "ole")
public class SrBom {


    public SrBom() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_id")
    private Integer bomId;

    @Column(name = "sample_id")
    private Integer sample_id;

    @Column(name = "item_id")
    private Integer item_id;

    @Column(name = "item_grp")
    private String itemGrp;

    @Column(name = "item_sub_grp")
    private String itemSubGrp;

    @Column(name = "used_in")
    private String usedIn;

    @Column(name = "pair")
    private String pair;

    @Column(name = "bom_qty")
    private Double bomQty;

    @Column(name = "stock_consumed_qty")
    private Double stockConsumedQty;

    @Column(name = "req_qty")
    private Double reqQty;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "unit")
    private String unit;

    @Column(name = "bom_type")
    private String bomType;

    @Column(name = "bom_status")
    private String bomStatus;

    @Column(name = "supplier_id")
    private Integer supplier_id;

    @Column(name = "username")
    private String username;

    @Column(name = "bomApprovedBy")
    private String bomApprovedBy;

    @Column(name = "entDate")
    private Date entDate;
}
