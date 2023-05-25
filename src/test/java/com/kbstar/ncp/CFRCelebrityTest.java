package com.kbstar.ncp;

import com.kbstar.util.CFRCelebrityUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class CFRCelebrityTest {

    @Value("${uploadimgdir}")
    String imgpath;


    @Test
    void contextLoads() throws Exception{
        String imgname = "jin2.jpg";
        JSONObject result = (JSONObject) CFRCelebrityUtil.getResult(imgpath, imgname);

        log.info(result.toJSONString());
    }
}