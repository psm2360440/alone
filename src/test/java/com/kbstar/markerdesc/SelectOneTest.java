package com.kbstar.markerdesc;

import com.kbstar.dto.Item;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class SelectOneTest {

    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads() {
        List<Item> list = null;

        try {
            markerDescService.get(1001);


        } catch(Exception e) {
                log.info("시스템 장애입니다.");
                e.printStackTrace();    }

        }
    }

