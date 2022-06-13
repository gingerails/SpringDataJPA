package com.genpt.springdatajpa;

import com.genpt.springdatajpa.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJpaApplicationTests {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void queryData(){

    }
}
