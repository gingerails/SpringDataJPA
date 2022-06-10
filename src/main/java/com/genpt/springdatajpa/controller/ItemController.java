package com.genpt.springdatajpa.controller;

import com.genpt.springdatajpa.entities.Items;
import com.genpt.springdatajpa.repository.ItemRepository;
import com.genpt.springdatajpa.services.ItemService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping(path="/itemlookup", produces = "application/json")
    List<Items> queryGivenItems(@RequestParam(value = "id", required = false) int[] intId){

        if(intId == null || intId.length == 0){     // has reference type, no obj
            return itemService.getAll();
        }else{
            return itemService.findAllByIDIn(intId);
        }

    }

}
//    @GetMapping(path="/itemlookup")
//    //goto service class
//    List<Items> queryData(){
//        return itemService.getAll();
//
//    }

//    @GetMapping(path="/{id}")
//    List<Items> queryGivenItems(@PathVariable("id") String stringId){
//        return itemRepository.findAllByID(stringId);
//    }

//    List<Items> queryItem(){
//        ArrayList itemList =new ArrayList<>();
//        return itemService.getAll();
//    }

//    @GetMapping(path = "/hello")
//    ResponseEntity<String> hello(){
//        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
//    }
//    List<Items> queryItem(){
//        List<Items> itemList = new ArrayList<>();
//        itemRepository.findById().forEach(Item -> itemList.add(Item));
//        return itemList;
//    }

//    @GetMapping("/o")
//    public String index(){
//        return "Hello world";
//    }