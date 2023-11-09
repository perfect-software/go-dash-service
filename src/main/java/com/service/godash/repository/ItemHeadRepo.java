package com.service.godash.repository;

import com.service.godash.model.ItemHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemHeadRepo extends JpaRepository<ItemHead,Integer> {
}
