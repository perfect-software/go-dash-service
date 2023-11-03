package com.service.godash.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Color",schema = "ole")
public class Color {

    @Id
    @Column(name = "color_id")
    private int color_id;

    @Column(name = "color")
    private String color;
}
