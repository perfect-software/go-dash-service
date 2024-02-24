package com.service.godash.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="ArticleMST",schema = "ole")
public class ArticleMST {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articlemst_id")
    private int articleMstId;

    @Column(name="article_no")
    private String articleNo;

    @Column(name="last_no")
    private String lastNo;

}
