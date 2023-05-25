package com.kbstar.weather;

import com.kbstar.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;

@Slf4j
@SpringBootTest
class WeatherTest {

    @Test
    void contextLoads() throws Exception {
    String result = null;
    result = WeatherUtil.getWeather1("109");
    log.info("--------------------"+result);
    }
}

