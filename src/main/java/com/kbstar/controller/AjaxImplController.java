package com.kbstar.controller;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.WeatherUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//import static com.sun.java.util.jar.pack.Utils.log;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }

    @Autowired
    CustService custService;
    @Autowired
    CartService cartService;

    @RequestMapping("/checkid")
    public Object checkid(String id) throws Exception {

        int result = 0;
        Cust cust= null;

        try {
            cust = custService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0005");
        }
        if(cust!=null){
            result = 1;
        }
        return result;
    }

    @RequestMapping("/getdata")
    public Object getdata(){

        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01", "pwd01", "james"));
        list.add(new Cust("id02", "pwd02", "Harry"));
        list.add(new Cust("id03", "pwd03", "Ron"));
        list.add(new Cust("id04", "pwd04", "Malfoy"));
        list.add(new Cust("id05", "pwd05", "Smith"));

        //Java Object ---> JSON
        //JSON(JavaScript Object Notation)
        //[{}, {}, {},...]
        JSONArray ja = new JSONArray();

        for(Cust obj:list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1;
            jo.put("id", obj.getId());
            jo.put("pwd", obj.getPwd());
            jo.put("name", obj.getName()+i);
            ja.add(jo);
        }

        return ja;
    }

    @Autowired
    MarkerService markerService;
    @RequestMapping("/markers")
    public Object markers(String loc) throws Exception {

        List<Marker> list = null;
        try {
            list = markerService.getLoc(loc);
        }catch (Exception e) {
            throw new Exception("시스템 장애: ER0003");
        }

        JSONArray ja = new JSONArray();
        for(Marker obj:list){
            JSONObject jo = new JSONObject();
            jo.put("id", obj.getId());
            jo.put("title", obj.getTitle());
            jo.put("target", obj.getTarget());
            jo.put("lat", obj.getLat());
            jo.put("lng", obj.getLng());
            jo.put("img", obj.getImg());
            jo.put("loc", obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }


    @RequestMapping("/chart0501")
    public Object chart0501(String year){
        JSONArray ja = new JSONArray();
        for(int i = 1; i <= 12; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    }

    @RequestMapping("/addcart")
    public Object addcart(Cart cart) throws Exception {

        cartService.register(cart);

        return "";
    }

    @ Value("${uploadimgdir}")
    String imgdir;

    @RequestMapping("/saveimg")
    public String saveimg(MultipartFile file){
        String filename = file.getOriginalFilename();
        FileUploadUtil.saveFile(file, imgdir);
        return filename;
    }

    @RequestMapping("/weather2")
    public Object weather2 () throws  Exception{
        return WeatherUtil.getWeather3();
    }
}