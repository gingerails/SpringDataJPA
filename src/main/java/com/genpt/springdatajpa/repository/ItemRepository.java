package com.genpt.springdatajpa.repository;

import com.genpt.springdatajpa.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
    List<Items> findAllByIDIn(int[] id);        // Called by ItemService.findAllByIDIn

    List<Items> findAllByOrderByPriceDesc();    // Called in ItemService.getAll

    List<Items> findAllByBrandIn(String[] brandName);
}
