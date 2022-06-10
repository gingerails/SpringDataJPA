package com.genpt.springdatajpa.services;

import com.genpt.springdatajpa.entities.Items;
import com.genpt.springdatajpa.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    @Override
    public Comparator reversed() {
        return Comparator.super.reversed();
    }
}
// getall return itemservice.getAll