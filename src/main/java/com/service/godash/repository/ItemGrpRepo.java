package com.service.godash.repository;

import com.service.godash.model.ItemGrp;
import com.service.godash.payload.ItemGrpAndSubGrp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGrpRepo extends JpaRepository<ItemGrp,Integer> {
}
