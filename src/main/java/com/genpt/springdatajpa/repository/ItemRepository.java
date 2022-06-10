package com.genpt.springdatajpa.repository;

import com.genpt.springdatajpa.entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
    List<Items> findAllByIDIn(int[] id);

    List<Items> findAllByOrderByPriceDesc();
}
