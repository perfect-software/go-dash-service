package com.service.godash.repository;

import com.service.godash.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepo extends JpaRepository<Item, Integer> {

//    @Query("SELECT NEW com.service.godash.payload.BuyerResponse(b.bs_id, b.bsName , b.deliveryAddress) FROM Buyer b WHERE LOWER(b.bsName) LIKE %:partialName%")
//    List<BuyerResponse> findBsNameContainingIgnoreCase(@Param("partialName") String partialName);
    @Query("SELECT i.itemname FROM Item i WHERE LOWER(i.itemname) LIKE %:input%")
    List<String> findItemNameContainingIgnoreCase(@Param("input") String input);

    boolean existsByitemname(String itemname);
}
