package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {

    @Autowired
    CartService service;
    @Test
    void contextLoads() {
        Cart obj = new Cart(100, "id01",100, 5);
        try {
            service.modify(obj);
            log.info("update OK--------------------------------");
            service.get(100);
        } catch (Exception e) {
            log.info("update error-----------------------------");
        }
    }

}
