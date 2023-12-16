package com.service.godash.payload;

import com.service.godash.model.Article;
import com.service.godash.model.Buyer;
import jakarta.persistence.*;

public class BomResponse {

//    @Column(name = "sample_id")
    private int sampleId;

    private Buyer buyer;

    private Article article;

}
