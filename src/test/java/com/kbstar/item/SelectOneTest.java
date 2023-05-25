package com.kbstar.item;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.AdmService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectOneTest {

    @Autowired
    ItemService service;
    @Test
    void contextLoads() {
        List<Item> list = null;

        try {
            service.get(100);


        } catch(Exception e) {
                log.info("시스템 장애입니다.");
                e.printStackTrace();    }

        }
    }

