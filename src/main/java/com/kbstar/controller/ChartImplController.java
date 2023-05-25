package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
    public Object chart02() {
        //{ "category":[], ...} 형태의 데이터 전송할 것.
        JSONObject jo = new JSONObject();
        JSONArray jaCnt = new JSONArray();
        for (int i = 1; i <= 12; i++) {
            Random r = new Random();
            int cnt = r.nextInt(10000) + 1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for (int i = 2011; i <= 2023; i++) {
            jaYear.add(i);
        }
        jo.put("category", jaYear);
        jo.put("datas", jaCnt);

        return jo;
    }

    @RequestMapping("/chart0301")
    public Object chart0301() {
        JSONArray ja = new JSONArray();
        for (int i = 1; i <= 5; i++) {
            Random r = new Random();
            int num = r.nextInt(20) + 1;
            JSONArray jadata = new JSONArray();
            jadata.add("data:" + num);
            jadata.add(num);
            ja.add(jadata);
        }

        return ja;
    }

    @RequestMapping("/chart0302")
    public Object chart0302() {

        JSONObject jo = new JSONObject();
        JSONArray jaCnt = new JSONArray();
        JSONArray jaCnt2 = new JSONArray();
        JSONArray jaCnt3 = new JSONArray();


        for (int i = 1; i <= 3; i++) {
            Random r = new Random();
            int cnt = r.nextInt(20) + 1;
            jaCnt.add(cnt);
        }

        for (int i = 1; i <= 3; i++) {
            Random r = new Random();
            int cnt = r.nextInt(20) + 1;
            jaCnt2.add(cnt);

        }

        for (int i = 1; i <= 3; i++) {
            Random r = new Random();
            int cnt = r.nextInt(20) + 1;
            jaCnt3.add(cnt);
        }

        JSONArray jaYear = new JSONArray();
        for (int i = 2021; i <= 2023; i++) {
            jaYear.add(i);
        }
        jo.put("category", jaYear);
        jo.put("datas", jaCnt);
        jo.put("datas2", jaCnt2);
        jo.put("datas3", jaCnt3);

        return jo;
    }

    @RequestMapping("/chart0303")
    public Object chart0303() {
        JSONArray ja = new JSONArray();
        JSONArray ja2 = new JSONArray();
        JSONArray ja3 = new JSONArray();

        JSONObject jofinal = new JSONObject();

        for (int i = 1; i <= 30; i++) {
            Random r = new Random();
            int num = r.nextInt((1000));
            ja.add(num);
        }


        for (int i = 1; i <= 30; i++) {
            Random r = new Random();
            int num = r.nextInt((1000));
            ja2.add(num);
        }

        for (int i = 1; i <= 30; i++) {
            Random r = new Random();
            int num = r.nextInt((1000));
            ja3.add(num);
        }

        jofinal.put("a", ja);
        jofinal.put("b", ja2);
        jofinal.put("c", ja3);

        return jofinal;
    }


    @RequestMapping("/chart0304")
    public Object chart0304() {
        JSONArray ja = new JSONArray();
        for (int i = 1; i <= 5; i++) {
            Random r = new Random();
            int num = r.nextInt(5000) + 1000;
            JSONArray jadata = new JSONArray();
            jadata.add("data:" + num);
            jadata.add(num);
            ja.add(jadata);
        }

        return ja;
    }




}
