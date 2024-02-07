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
    @Column(name = "article_nm")
    private String articleName;
    @Column(name ="image_nm")
    private String image_nm;
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

    public Article(ArticleRequest request){
        this.articleName= StringUtils.upperCase(request.getArticleName());
        this.animal=StringUtils.upperCase(request.getAnimal());
        this.color=StringUtils.upperCase(request.getColor());
        this.category=StringUtils.upperCase(request.getCategory());
        this.gender=StringUtils.upperCase(request.getGender());
        this.soleType=StringUtils.upperCase(request.getSoleType());
        this.toeShape=StringUtils.upperCase(request.getToeShape());
        this.platformType=StringUtils.upperCase(request.getPlatformType());
        this.platformNo=StringUtils.upperCase(request.getPlatformNo());
        this.heelHeight=StringUtils.upperCase(request.getHeelHeight());
        this.heelNo=StringUtils.upperCase(request.getHeelNo());
        this.heelType=StringUtils.upperCase(request.getHeelType());
        this.lastNo=StringUtils.upperCase(request.getLastNo());
        this.liningMaterial=StringUtils.upperCase(request.getLiningMaterial());
        this.socksMaterial=StringUtils.upperCase(request.getSocksMaterial());
        this.comment=StringUtils.upperCase(request.getComment());
        this.username=StringUtils.upperCase(request.getUsername());
        this.image_nm=request.getImage_nm();
    }

    public Article() {
    }

}
