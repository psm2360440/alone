package com.kbstar.ncp;

import com.kbstar.util.CFRFaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CFRFaceTest {

    @Value("${uploadimgdir}")
    String imgpath;


    @Test
    void contextLoads() throws Exception{
        String imgname = "jin2.jpg";
        JSONObject result = (JSONObject) CFRFaceUtil.getResult("C:/project/uimg/", imgname);

        log.info(result.toJSONString());
    }
}