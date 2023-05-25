package com.kbstar.markerdesc;

import com.kbstar.dto.MarkerDesc;
import com.kbstar.service.MarkerDescService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class InsertTest {

    @Autowired
    MarkerDescService markerDescService;
    @Test
    void contextLoads() {
        MarkerDesc markerdesc = new MarkerDesc( 108, "양꼬치", 20000, "yang2.jpg");
        try {

            markerDescService.register(markerdesc);
            log.info("register OK.......");
        } catch (Exception e) {
            log.info("register error.......");
            e.printStackTrace();
        }
    }

}