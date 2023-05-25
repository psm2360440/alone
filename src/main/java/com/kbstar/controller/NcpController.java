package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Ncp;
import com.kbstar.service.CustService;
import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import com.kbstar.util.FileUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class NcpController {

    @Value("${uploadimgdir}")
    String imgpath;
    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws Exception {
        //이미지 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath);
        //NCP요청
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRCelebrityUtil.getResult(imgpath, imgname);

        log.info(result.toJSONString());
        //결과수신

        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject)faces.get(0);
        JSONObject celebrity = (JSONObject) obj.get("celebrity");
        String value = (String) celebrity.get("value");


        model.addAttribute("result",value);
        model.addAttribute("center","cfr1");
        return "index";
    }


    @RequestMapping("/cfr2impl")
    public String cfr2impl(Model model, Ncp ncp) throws Exception {
        //이미지 저장
        FileUploadUtil.saveFile(ncp.getImg(),imgpath);
        //NCP요청
        String imgname = ncp.getImg().getOriginalFilename();
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);

        log.info(result.toJSONString());
        //결과수신


        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);


        String emotion_value = "";
        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        String gender_value = "";
        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        String pose_value = "";
        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        String age_value = "";
        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

        Map<String, String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("age", age_value);
        map.put("pose", pose_value);
        map.put("gender", gender_value);


        String result2 = emotion_value + gender_value + pose_value + age_value;

        model.addAttribute("result", map);

        model.addAttribute("center","cfr2");
        return "index";
    }

    @RequestMapping("/mycfr")
    public String mycfr(Model model, String imgname) throws Exception {

        //NCP요청
        JSONObject result = (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);

        log.info(result.toJSONString());
        //결과수신


        JSONArray faces = (JSONArray) result.get("faces");
        JSONObject obj = (JSONObject) faces.get(0);


        String emotion_value = "";
        JSONObject emotion = (JSONObject) obj.get("emotion");
        emotion_value = (String) emotion.get("value");

        String gender_value = "";
        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String) gender.get("value");

        String pose_value = "";
        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String) pose.get("value");

        String age_value = "";
        JSONObject age = (JSONObject) obj.get("age");
        age_value = (String) age.get("value");

        Map<String, String> map = new HashMap<>();
        map.put("emotion", emotion_value);
        map.put("age", age_value);
        map.put("pose", pose_value);
        map.put("gender", gender_value);


        String result2 = emotion_value + gender_value + pose_value + age_value;

        model.addAttribute("result", map);

        model.addAttribute("center","pic");
        return "index";
    }

    @Autowired
    CustService custService;

    @RequestMapping("/mycfr2")
    public String mycfr2(Model model, HttpSession session) throws Exception {
        //현재 타임스탬프
        Timestamp current = new Timestamp(System.currentTimeMillis());
        log.info(current.toString()+"-----------------------------------------------------------------------");
        //스트링 변환
        String current_str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(current);
        log.info(current_str+"-----------------------------------------------------------------------");
        //특정일의 특정시간 스트링값 구하기
        String compare_str = new SimpleDateFormat("yyyy/MM/dd").format(current).concat(" 09:00:00");
        log.info(compare_str+"-----------------------------------------------------------------------");
        //스탬프와 특정시간 비교

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime current_tm = LocalDateTime.parse(current_str, formatter);
        LocalDateTime compare_tm = LocalDateTime.parse(compare_str, formatter);

        String result = "";
        Cust cust = (Cust) session.getAttribute("logincust");
        if(current_tm.isBefore(compare_tm)) {
            result = cust.getName() + "님 오늘도 열코딩 하십시오!";
        } else {
            Duration duration = Duration.between(compare_tm, current_tm); // 두 LocalDateTime 객체 사이의 시간 차이 계산

            long minutes = duration.toMinutes(); // 분 단위로 변환
            String minutesString = Long.toString(minutes);//String 변환

            System.out.println("두 LocalDateTime 객체 간의 분 차이: " + minutes);
            result = "오늘은 "+ minutesString + "분 늦었습니다! " + cust.getName() + "님 내일은 조금 더 일찍 오십시오!";
        }

        //리턴
        model.addAttribute("result", result);
        model.addAttribute("center","pic");
        return "index";
    }




}
