package com.service.godash.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "ItemQuotation",schema = "ole")
public class ItemQuo {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "item_quotation_id")
    @JsonIgnore
    private Integer item_quotation_id;

    @Column(name = "item_id")
    private Integer ItemId;

    @Column(name = "supplier_id")
    private Integer SupplierId;

    @Column(name = "rate")
    private Double Rate;

}
