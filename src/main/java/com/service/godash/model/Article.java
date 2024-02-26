package com.service.godash.model;

import com.service.godash.payload.ArticleRequest;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

@Entity
@Data
@Table(name="Article",schema = "ole")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private int articleId;

    @Column(name = "articlemst_id")
    private int articleMstId;

    @Column(name="article_no")
    private String article_no;

    @Column(name = "article_nm")
    private String articleName;

    @Column(name ="image_nm")
    private String image_nm;

    @Column(name = "animal")
    private String animal;

    @Column(name = "leather")
    private String leather;

    @Column(name = "color")
    private String color;

    @Column(name = "color_code")
    private String colorCode;

    @Column (name = "gender")
    private String gender;

    @Column(name = "sole")
    private String sole;

    @Column(name = "insole")
    private String insole;

    @Column(name = "sole_type")
    private String soleType;

    @Column(name = "toe_shape")
    private String toeShape;

    @Column(name = "category")
    private String category;

    @Column(name = "sub_category")
    private String subcategory;

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

    @Column(name = "last_type")
    private String lastType;

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

    public Article(ArticleRequest request){
        this.article_no=StringUtils.upperCase(request.getArticleNo().trim());
        this.articleName= StringUtils.upperCase(request.getArticleName().trim());
        this.animal=StringUtils.upperCase(request.getAnimal().trim());
        this.leather=StringUtils.upperCase(request.getLeather().trim());
        this.color=StringUtils.upperCase(request.getColor().trim());
        this.colorCode=StringUtils.upperCase(request.getColorCode().trim());
        this.category=StringUtils.upperCase(request.getCategory().trim());
        this.subcategory=StringUtils.upperCase(request.getSubCategory().trim());
        this.gender=StringUtils.upperCase(request.getGender().trim());
        this.sole=StringUtils.upperCase(request.getSole().trim());
        this.insole=StringUtils.upperCase(request.getInsole().trim());
        this.soleType=StringUtils.upperCase(request.getSoleType().trim());
        this.toeShape=StringUtils.upperCase(request.getToeShape().trim());
        this.platformType=StringUtils.upperCase(request.getPlatformType().trim());
        this.platformNo=StringUtils.upperCase(request.getPlatformNo().trim());
        this.heelHeight=StringUtils.upperCase(request.getHeelHeight().trim());
        this.heelNo=StringUtils.upperCase(request.getHeelNo().trim());
        this.heelType=StringUtils.upperCase(request.getHeelType().trim());
        this.lastNo=StringUtils.upperCase(request.getLastNo().trim());
        this.liningMaterial=StringUtils.upperCase(request.getLiningMaterial().trim());
        this.socksMaterial=StringUtils.upperCase(request.getSocksMaterial().trim());
        this.comment=StringUtils.upperCase(request.getComment().trim());
        this.username=StringUtils.upperCase(request.getUsername().trim());
        this.image_nm=request.getImage_nm().trim();
    }

    public Article() {
    }

}
