package com.service.godash.repository;

import com.service.godash.model.Item;
import com.service.godash.payload.ItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Integer> {

 @Query("SELECT NEW com.service.godash.payload.ItemResponse(i.itemId,i.itemname) FROM Item i" )
    List<ItemResponse> findItemName();

    boolean existsByitemname(String itemname);

    Item findByItemId(Integer itemId);
}
