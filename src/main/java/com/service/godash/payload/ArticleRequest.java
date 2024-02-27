package com.service.godash.payload;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ArticleRequest {
    @Size(max=20,message = "article number exceeding char limit")
    private String articleNo;
    @Size(max=50,message = "article name exceeding char limit")
    private String articleName;
    @Size(max=10,message = "animal exceeding char limit")
    private String animal;
    @Size(max=10,message = "leather exceeding char limit")
    private String leather;
    @Size(max=50,message = "color exceeding char limit")
    private String color;
    @Size(max=20,message = "color code exceeding char limit")
    private String colorCode;
    @Size(max=10,message = "gender exceeding char limit")
    private String gender;
    @Size(max=20,message = "sole exceeding char limit")
    private String sole;
    @Size(max=50,message = "insole exceeding char limit")
    private String insole;
    @Size(max=10,message = "season exceeding char limit")
    private String season;
    @Size(max=50,message = "sole type exceeding char limit")
    private String soleType;
    @Size(max=50,message = "toe shape exceeding char limit")
    private String toeShape;
    @Size(max=50,message = "category exceeding char limit")
    private String category;
    @Size(max=50,message = "sub category exceeding char limit")
    private String subCategory;
    @Size(max=50,message = "platform type exceeding char limit")
    private String platformType;
    @Size(max=50,message = "platform no exceeding char limit")
    private String platformNo;
    @Size(max=50,message = "heel type exceeding char limit")
    private String heelType;
    @Size(max=50,message = "heel number exceeding char limit")
    private String heelNo;
    @Size(max=50,message = "heel height exceeding char limit")
    private String heelHeight;
    @Size(max=50,message = "last no exceeding char limit")
    private String lastNo;
    @Size(max=50,message = "last type exceeding char limit")
    private String lastType;
    @Size(max=50,message = "lining material exceeding char limit")
    private String liningMaterial;
    @Size(max=50,message = "socks material exceeding char limit")
    private String socksMaterial;
    @Size(max=255,message = "comment exceeding char limit")
    private String comment;
//    @Size(max=10,message = "username exceeding char limit")
//    private String username;
    @Size(max=200,message = "image name exceeding char limit")
    private String image_nm;

}
