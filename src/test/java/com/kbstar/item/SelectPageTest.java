package com.kbstar.item;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Item;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectPageTest {

    @Autowired
    ItemService itemService;


    @Test
    void contextLoads() {
        PageInfo<Item> pageInfo;


        try {
            pageInfo = new PageInfo<>(itemService.getPage(1), 5); // 5:하단 네비게이션 개수

        } catch (Exception e) {
                log.info("시스템 장애입니다.");
                e.printStackTrace();
            }

//            log.info("register error.......");
//            e.printStackTrace();
        }
    }

