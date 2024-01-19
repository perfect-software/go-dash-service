package com.service.godash.repository;

import com.service.godash.model.ItemQuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemQuotationRepo extends JpaRepository<ItemQuo,Integer>{
}
