package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "itemHead",schema = "ole")
public class ItemHead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_header_id")
    private int itemHeadId;

    @Column(name = "head")
    private String head;

    @Column(name = "value")
    private String value;
}
