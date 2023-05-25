package com.kbstar.adm;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class InsertTest {
    @Autowired
    AdmService service;

    @Test
    void contextLoads() throws Exception {
        Adm obj = new Adm("id99", "pwd99", 99);
        try {
            service.register(obj);
            log.info("등록 정상");
        } catch (Exception e) {
            if (e instanceof DuplicateKeyException) {
                log.info("이미 사용 중인 ID입니다!----------------------------------------");
            } else {
                log.info("등록에러..");
                e.printStackTrace();
            }
        }
    }
}

