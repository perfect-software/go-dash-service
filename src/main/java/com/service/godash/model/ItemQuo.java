package com.service.godash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "ItemQuotation",schema = "ole")
public class ItemQuo {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "item_quotation_id")
    @JsonIgnore
    private Integer item_quotation_id;

    @JoinColumn(name = "item_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    @JoinColumn(name = "supplier_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Supplier supplier;

    @Column(name = "rate")
    private Double Rate;

    @Column(name = "unit")
    private String Unit;

    @Column(name = "validUntil")
    private Date ValidUntil;

}
