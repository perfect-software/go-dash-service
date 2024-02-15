package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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

    @Column(name = "sr_no")
    private String srno;

    @Column(name = "bom_type")
    private String bomType;

    @Column(name = "bom_status")
    private String bomStatus;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "bomApprovedBy")
    private String bomApprovedBy;

    @Column(name = "entDate")
    private LocalDateTime entDate;
}
