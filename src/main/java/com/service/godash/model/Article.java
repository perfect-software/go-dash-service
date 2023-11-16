package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="Article",schema = "ole")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;
    @Column(name = "article_nm")
    private String articleName;
    @Column(name = "animal")
    private String animal;
    @Column(name = "color")
    private String color;
    @Column (name = "gender")
    private String gender;
    @Column(name = "sole_type")
    private String soleType;
    @Column(name = "toe_shape")
    private String toeShape;
    @Column(name = "category")
    private String category;
    @Column(name = "platform_type")
    private String platformType;
    @Column(name = "platform_no")
    private String platformNo;
    @Column(name = "heel_type")
    private String heelType;
    @Column(name = "heel_no")
    private String heelNo;
    @Column(name = "heel_height")
    private String heelHeight;
    @Column(name = "last_no")
    private String lastNo;
    @Column(name = "lining_material")
    private String liningMaterial;
    @Column(name = "socks_material")
    private String socksMaterial;
    @Column(name = "comment")
    private String comment;
    @Column(name = "username")
    private String username;
    @Column(name = "entDate")
    private Date entDate;

}
