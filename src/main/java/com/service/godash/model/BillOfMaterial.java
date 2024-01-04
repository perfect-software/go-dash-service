package com.service.godash.model;

import com.service.godash.payload.BomRequest;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="SR_BOM",schema = "ole")
public class BillOfMaterial {

    public BillOfMaterial(BomRequest bomRequest) {
        this.sample_id = bomRequest.getSampleId();
        this.article_id = bomRequest.getArticleNo();
    }

    public BillOfMaterial() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_id")
    private Integer bomId;

    @Column(name = "sample_id")
    private Integer sample_id;

    @Column(name = "article_id")
    private Integer article_id;

    @Column(name = "item_id")
    private Integer item_id;

    @Column(name = "inv_id")
    private Integer invId;

    @Column(name = "used_in")
    private String usedIn;

    @Column(name = "pair")
    private String pair;

    @Column(name = "bom_qty")
    private Double bomQty;

    @Column(name = "req_qty")
    private Double reqQty;

    @Column(name = "bomType")
    private String bomType;

    @Column(name = "bomStatus")
    private String bomStatus;

    @Column(name = "bomVersion")
    private String bomVersion;

    @Column(name = "username")
    private String username;

    @Column(name = "bomApprovedBy")
    private String bomApprovedBy;

    @Column(name = "entDate")
    private Date entDate;
}
