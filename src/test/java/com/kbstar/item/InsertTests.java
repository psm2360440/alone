package com.kbstar.item;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Item;
import com.kbstar.service.AdmService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class InsertTests {

    @Autowired
    ItemService service;
    @Test
    void contextLoads() {
        Item obj = new Item(0,"모자",1000,"agd.jpg",null);
        try {
            service.register(obj);
            log.info("register OK.......");
        } catch (Exception e) {
//            if(e instanceof DuplicateKeyException){
//                log.info("id가 중복되었습니다.---------------");
//            }else{
//                log.info("시스템 장애입니다.");
//            }

            log.info("register error.......");
            e.printStackTrace();
        }
    }

}