package com.genpt.springdatajpa.controller;

import com.genpt.springdatajpa.entities.Items;
import com.genpt.springdatajpa.repository.ItemRepository;
import com.genpt.springdatajpa.services.ItemService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


import java.util.*;

/**
 * ItemController
 * /itemlookup allows user to enter IDs of products and get them back.
 *  If no ID is entered, it returns all IDs.
 */
@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    // GET HTTP
    // localhost:8080/itemlookup?id=1
    @GetMapping(path="/itemlookup", produces = "application/json")
    List<Items> queryGivenItems(@RequestParam(value = "id", required = false) int[] intId){

        if(intId == null || intId.length == 0){     // has reference type, no obj
            return itemService.getAll();
        }else{
            return itemService.findAllByIDIn(intId);
        }

    }

    /*
        Gets the brand
        GET HTTP
        localhost:8080/brandlookup?id=NAPA
     */
    @GetMapping(path="/brandlookup", produces = "application/json")
    List<Items> queryGivenBrand(@RequestParam(value = "brand", required = false) String[] brandName) {
        return itemService.findAllByBrandIn(brandName);
    }

}
