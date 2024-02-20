package com.service.godash.model;

import com.service.godash.payload.SrBomRequest;
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

    public SrBom(SrBomRequest request){
        this.srno=request.getSr_no().toUpperCase();
        this.bomType=request.getBomType().toUpperCase();
        this.createdBy="USER";
        this.entDate=LocalDateTime.now();
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
