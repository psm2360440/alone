package com.kbstar.item;

import com.kbstar.dto.Adm;
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
class DeleteTest {

    @Autowired
    ItemService service;
    @Test
    void contextLoads() {
        try {
            service.remove(50);
                log.info("삭제완료");
        } catch (Exception e) {
                log.info("시스템 장애입니다.");
            }

        }
    }

