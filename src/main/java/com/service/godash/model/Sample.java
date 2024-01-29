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
        this.season = StringUtils.upperCase(request.getSeason());
        this.sampleRef = StringUtils.upperCase(request.getSampleRef());
        this.sampleType = StringUtils.upperCase(request.getSampleType());
        this.article_no = StringUtils.upperCase(request.getArticleNo());
        this.buyerArticle = StringUtils.upperCase(request.getBuyerArticle());
        this.size = StringUtils.upperCase(request.getSize());
        this.quantity = StringUtils.upperCase(request.getQuantity());
        this.pair = StringUtils.upperCase(request.getPair());
        this.upperColor = StringUtils.upperCase(request.getUpperColor());
        this.liningColor = StringUtils.upperCase(request.getLiningColor());
        this.last = StringUtils.upperCase(request.getLast());
        this.insole = StringUtils.upperCase(request.getInsole());
        this.soleLabel = StringUtils.upperCase(request.getSoleLabel());
        this.socks = StringUtils.upperCase(request.getSocks());
        this.heel =StringUtils.upperCase(request.getHeel());
        this.pattern = StringUtils.upperCase(request.getPattern());
        this.buyerRef = StringUtils.upperCase(request.getBuyerRef());
        this.inUpperLeather = StringUtils.upperCase(request.getInUpperLeather());
        this.inLining = StringUtils.upperCase(request.getInLining());
        this.inSocks = StringUtils.upperCase(request.getInSocks());
        this.inQuantity = StringUtils.upperCase(request.getInQuantity());
        this.comments = StringUtils.upperCase(request.getComments());
        this.deliveryDate = (request.getDeliveryDate());
        this.prodExDate = request.getProdExDate();
        this.dateOfOrder=request.getDateOfOrder();
        this.finYear = request.getFinYear();

    }


    @Id
    @Column(name = "sample_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sampleId;

    @Column(name = "sr_no",length = 20)
    private String sr_no;


    @Column(name = "season")
    private String season;

    @Column(name = "sample_ref")
    private String sampleRef;

    @Column(name = "sample_type")
    private String sampleType;

    @Column(name = "article_no")
    private String article_no;

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

    @Column(name ="order_date")
    private Date dateOfOrder;

    @Column(name = "fin_year")
    private String finYear;

    @ManyToOne //defines many sample id against one buyer
    @JoinColumn(name = "bs_id")
    private Buyer buyer;

//    public static void toUpperCase(){
//        this.season= StringUtils.upperCase(season);
//        this.sampleRef=StringUtils.upperCase(this.sampleRef);
//        this.sampleType=StringUtils.upperCase(this.sampleType);
//        this.article_no=StringUtils.upperCase(this.article_no);
//        this.buyerArticle=StringUtils.upperCase(this.buyerArticle);
//        this.size=StringUtils.upperCase(this.size);
//        this.quantity=StringUtils.upperCase(this.quantity);
//        this.pair=StringUtils.upperCase(this.pair);
//        this.upperColor=StringUtils.upperCase(this.upperColor);
//        this.liningColor=StringUtils.upperCase(this.liningColor);
//        this.last=StringUtils.upperCase(this.last);
//        this.insole=StringUtils.upperCase(this.insole);
//        this.soleLabel=StringUtils.upperCase(this.soleLabel);
//        this.socks=StringUtils.upperCase(this.socks);
//        this.heel=StringUtils.upperCase(this.heel);
//        this.pattern=StringUtils.upperCase(this.pattern);
//        this.buyerRef=StringUtils.upperCase(this.buyerRef);
//        this.inUpperLeather=StringUtils.upperCase(this.inUpperLeather);
//        this.inLining=StringUtils.upperCase(this.inLining);
//        this.inSocks=StringUtils.upperCase(this.inSocks);
//        this.inQuantity=StringUtils.upperCase(this.inQuantity);
//        this.comments=StringUtils.upperCase(this.comments);
//    }

}
