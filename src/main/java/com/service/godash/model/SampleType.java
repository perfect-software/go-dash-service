package com.service.godash.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="SampleType",schema = "ole")
public class SampleType {
    @Id
    @Column(name = "sampletype_id")
    private int sampletype_id;
    @Column(name = "type")
    private String type;
}
