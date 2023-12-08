package com.service.godash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Entity
@Data
@Table(name="BOM",schema = "ole")
public class BillOfMaterial {
    private Integer bomId;
    private Integer bsId;//Buyer ID
    private Integer articleId;//Article Number
    private Integer item_id;//Item Number
    private Integer bomDesc;//Description of the BOM
    private String bomType;//Sample or Production
    private String bomStatus;//Draft or Approved
    private String bomVersion;//1.0, 2.0, 3.0
    private String bomDate;
    private String bomCreatedBy;
    private String bomCreatedDate;
    private String bomUpdatedBy;
    private String bomUpdatedDate;
    private String bomApprovedBy;
    private String bomApprovedDate;
    private String bomApprovedStatus;
    private String bomApprovedComments;

}
