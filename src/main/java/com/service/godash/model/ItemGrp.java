package com.service.godash.model;

import com.service.godash.payload.ItemGrpAndSubGrp;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "itemGrp",schema = "ole")
@Data
public class ItemGrp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int item_id;
    @Column(name = "item_grp")
    private String itemGrp;
    @Column(name = "item_sub_grp")
    private String itemSubGrp;
    @Column(name = "item_grp_nm")
    private String itemGrpName;
    @Column(name = "item_sub_grp_nm")
    private String itemSubGrpName;

    public ItemGrp(ItemGrpAndSubGrp request){
        this.itemGrp=request.getItemGrp();
        this.itemGrpName= request.getItemGrpName();
        this.itemSubGrp= request.getItemSubGrp();
        this.itemSubGrpName=request.getItemSubGrpName();
    }

    public ItemGrp(){

    }
}
