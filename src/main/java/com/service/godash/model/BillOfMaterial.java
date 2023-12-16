package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Entity
@Data
@Table(name="SR_BOM",schema = "ole")
public class BillOfMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_id")
    private Integer bomId;

    @ManyToOne
    @JoinColumn(name = "sample_id")
    private Sample sample;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

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
