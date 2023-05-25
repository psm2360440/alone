package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import com.kbstar.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @Value("${adminserver}")
            String adminserver;

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @RequestMapping("/")
    public String main(Model model) throws Exception{
//        String result = WeatherUtil.getWeather1("109");
//        model.addAttribute("weatherinfo",result);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/custinfo")
    public String custinfo(Model model, String id) throws Exception {
        Cust cust = null;
        try {
            cust = custService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템장애");
        }
        model.addAttribute("custinfo", cust);
        model.addAttribute("center", "custinfo");
        return "index";
    }

    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model, Cust cust) throws Exception {

        try {
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.modify(cust);
        } catch (Exception e) {
            throw new Exception("시스템장애");
        }

        return "redirect:/custinfo?id="+cust.getId();
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd, HttpSession session) throws Exception {
        logger.info("information" + id + " " + pwd);
        Cust cust = null;
        String nextPage = "loginfail";
        try {
            cust = custService.get(id);
            //앤퍼샌트두개: 앞애서 실패하면 뒷 부분을 굳이 실행하지 않는다.
            if(cust != null && encoder.matches(pwd,cust.getPwd())){
                nextPage = "loginok";
                // max시간이 지나면 자동으로 로그아웃
               //session에 담은 정보도 jsp화면단에서 $사인으로 접근 가능하다
                session.setMaxInactiveInterval(1000000);
                session.setAttribute("logincust", cust);
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애입니다. 잠시 후 다시 로그인 하십시오!");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session) throws Exception {
        if(session != null){
            session.invalidate();
        }
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    CustService custService;
    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust, HttpSession session) throws Exception {
        try {
            //화면에서 입력한 패스워드를 가져와 그것을 암호화 한 후, cust 객체에 넣는다
            cust.setPwd(encoder.encode(cust.getPwd()));
            custService.register(cust);
            session.setAttribute("logincust", cust);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0006");
        }
        model.addAttribute("rcust", cust);
        model.addAttribute("center", "registerok");
        return "index";
    }


    @RequestMapping("/pic")
    public String pic(Model model, Cust cust) throws Exception {
        model.addAttribute("cust", cust);
        model.addAttribute("center", "pic");
        return "index";
    }

    @RequestMapping("/websocket")
    public String websocket(Model model) throws Exception {
        model.addAttribute("adminserver", adminserver);
        model.addAttribute("center", "websocket");
        return "index";
    }


    @RequestMapping("/cfr1")
    public String cfr1(Model model) throws Exception {
        model.addAttribute("center", "cfr1");
        return "index";
    }


    @RequestMapping("/cfr2")
    public String cfr2(Model model) throws Exception {
        model.addAttribute("center", "cfr2");
        return "index";
    }



    // /quics?page=bs01 (GET: ? 앞의 명령어를 요청 ? 후는 데이터)
    @RequestMapping("/quics")
    public String quics(String page) {
        return page;
    }
}
