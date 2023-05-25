package com.kbstar.controller;

import com.github.pagehelper.PageInfo;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Item;
import com.kbstar.service.CartService;
import com.kbstar.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

//import static com.sun.java.util.jar.pack.Utils.log;

@Slf4j
@Controller
@RequestMapping("/item")

public class ItemController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    String dir = "item/";

    @Autowired
    CartService cartService;

    //127.0.0.1/item
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "add");
        return "index";
    }

    @RequestMapping("/list")
    public String list(Model model) throws Exception{

        List<Item> list = null;

        try {
            list = itemService.get();
            for(Item obj:list){
                log.info(obj.toString());
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");

        }

        model.addAttribute("allitem", list);


        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "list");
        return "index";
    }

    @Autowired
    ItemService itemService;
    @RequestMapping("/all")
    public String all(Model model) throws Exception {

        List<Item> list = null;

        try {
            list = itemService.get();
            for(Item obj:list){
                log.info(obj.toString());
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");

        }

        model.addAttribute("allitem", list);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "all");
        return "index";
    }

    @RequestMapping("/allpage")
    public String allpage(@RequestParam(required = false, defaultValue = "1") int pageNo, Model model) throws Exception {
        PageInfo<Item> p;
        try {
            p = new PageInfo<>(itemService.getPage(pageNo), 5); // 5:하단 네비게이션 개수
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0001");
        }
        model.addAttribute("target","item");

        model.addAttribute("cpage",p);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"allpage");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model, Integer id) throws Exception{
        Item item = null;
        item = itemService.get(id);
        model.addAttribute("gitem", item);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "get");
        return "index";
    }

    @RequestMapping("/allcart")
    public String allcart(Model model, String id) throws Exception {

        List<Cart> list = null;

        try {
            list = cartService.getMyCart(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애: ER0002");
        }

        model.addAttribute("allcart", list);
        model.addAttribute("center", "cart");
        return "index";
    }


    @RequestMapping("/addcart")
    public String addcart(Model model, Cart cart) throws Exception {
        cartService.register(cart);
        return "redirect:/item/allcart?id="+cart.getCust_id();
    }

    @RequestMapping("/delcart")
    public String delcart(Model model, Integer id,  HttpSession session) throws Exception {
        cartService.remove(id);
        if(session != null){
            Cust cust = (Cust) session.getAttribute("logincust");
            return "redirect:/item/allcart?id="+cust.getId();
        }
        return "redirect:/";
    }

}
