package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="SampleRequest",schema = "ole")
public class SampleRef {

    public SampleRef(){}

    @Id
    @Column(name = "sample_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleId;

    @Column(name = "sr_no")
    private String srno;

    @ManyToOne //defines many sample id against one buyer
    @JoinColumn(name = "bs_id")
    private Buyer buyer;
}
