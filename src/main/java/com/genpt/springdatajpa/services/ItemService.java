package com.genpt.springdatajpa.services;

import com.genpt.springdatajpa.entities.Items;
import com.genpt.springdatajpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * File: ItemService.java
 * Author: Abi Kunkle
 * Called by ItemController.
 * Calls itemRepository for getAll, findAllByIDIn functions
 */
@Service
public class ItemService implements Comparator{
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Items> getAll() {                       //CRUD syntax
        List<Items> itemList = new ArrayList<>();
        itemRepository.findAllByOrderByPriceDesc().forEach(Item -> itemList.add(Item));
        return itemList;
    }

    public List<Items> findAllByIDIn(int[] intID){
        List<Items> itemList = new ArrayList<>();
        itemRepository.findAllByIDIn(intID).forEach(Item -> itemList.add(Item));
        return itemList;
    }


    //New Addition as of 06/13
    // Does the same as findAllByIdIn, except it can search/filter by brand name. Has a different getMapping
    public List<Items> findAllByBrandIn(String[] brandName){
        List<Items> brandList = new ArrayList<>();
        itemRepository.findAllByBrandIn(brandName).forEach(Item -> brandList.add(Item));
        return brandList;
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }

}
