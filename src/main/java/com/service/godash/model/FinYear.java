package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="FinYear",schema = "ole")
public class FinYear {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="year")
    private String year;

    @Column(name="Status")
    private String Status;
}
