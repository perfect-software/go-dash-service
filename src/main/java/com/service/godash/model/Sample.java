package com.service.godash.model;

import com.service.godash.payload.SampleRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.Year;
import java.util.Date;

@Entity
@Data
@Table(name="SampleRequest",schema = "ole")
public class Sample {

    public Sample() {
    }

    public Sample(SampleRequest request) {
        this.season = request.getSeason();
        this.sampleRef = request.getSampleRef();
        this.sampleType = request.getSampleType();
        this.articleNo = request.getArticleNo();
        this.buyerArticle = request.getBuyerArticle();
        this.size = request.getSize();
        this.quantity = request.getQuantity();
        this.pair = request.getPair();
        this.upperColor = request.getUpperColor();
        this.liningColor = request.getLiningColor();
        this.last = request.getLast();
        this.insole = request.getInsole();
        this.soleLabel = request.getSoleLabel();
        this.socks = request.getSocks();
        this.heel = request.getHeel();
        this.pattern = request.getPattern();
        this.buyerRef = request.getBuyerRef();
        this.inUpperLeather = request.getInUpperLeather();
        this.inLining = request.getInLining();
        this.inSocks = request.getInSocks();
        this.inQuantity = request.getInQuantity();
        this.comments = request.getComments();
        this.deliveryDate = request.getDeliveryDate();
        this.prodExDate = request.getProdExDate();
    }


    @Id
    @Column(name = "sample_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleId;
//
//    @Column(name = "sr_no")
//    private String srno;

    @Column(name = "season")
    private String season;

    @Column(name = "sample_ref")
    private String sampleRef;

    @Column(name = "sample_type")
    private String sampleType;

    @Column(name = "article_no")
    private String articleNo;

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

    @ManyToOne //defines many sample id against one buyer
    @JoinColumn(name = "bs_id")
    private Buyer buyer;

}
