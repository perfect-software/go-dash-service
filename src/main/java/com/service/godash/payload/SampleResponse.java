package com.service.godash.payload;

import com.service.godash.model.Buyer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name="SampleRequest",schema = "ole")
public class SampleResponse {
    @Id
    @Column(name = "sample_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleId;

    @Column(name = "sr_no")
    private String sr_no;

    @Column(name = "season")
    private String season;

    @Column(name = "sample_ref")
    private String sampleRef;

    @Column(name = "sample_type")
    private String sampleType;

    @Column(name = "article_no")
    private Integer articleNo;

    @Column(name = "buyer_article")
    private String buyerArticle;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "pair")
    private String pair;

    @Column(name = "upperColor")
    private String upperColor;

    @Column(name = "liningColor")
    private String liningColor;

    @Column(name = "last")
    private String last;

    @Column(name = "insole")
    private String insole;

    @Column(name = "solelable")
    private String soleLabel;

    @Column(name = "socks")
    private String socks;

    @Column(name = "heel")
    private String heel;

    @Column(name = "pattern")
    private String pattern;

    @Column(name = "buyer_ref")
    private String buyerRef;

    @Column(name = "in_upper_leather")
    private String inUpperLeather;

    @Column(name = "in_lining")
    private String inLining;

    @Column(name = "in_socks")
    private String inSocks;

    @Column(name = "in_quantity")
    private String inQuantity;

    @Column(name = "comments")
    private String comments;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "prod_ex_date")
    private Date prodExDate;

    @Column(name ="dateOfOrder")
    private Date dateOfOrder;

    @ManyToOne //defines many sample id against one buyer
    @JoinColumn(name = "bs_id")
    private Buyer buyer;


}
