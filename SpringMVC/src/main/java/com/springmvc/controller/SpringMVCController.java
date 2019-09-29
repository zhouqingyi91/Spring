package com.springmvc.controller;

import com.springmvc.po.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMVCController {

    @RequestMapping("test/show/param")
    public String test(HttpServletRequest request, ModelAndView modelAndView) {
        // http://localhost:8080/mvc/test/show/param?id=3&name=haha&price=89.1
        Item item = new Item();
        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setName(request.getParameter("name"));
        item.setPrice(Float.parseFloat(request.getParameter("price")));

        modelAndView.addObject("item", item);
        System.out.println(1 / 0);

        return "showParam"; //这个页面好像不是展示的, 而是用来测试post提交的
    }

    @RequestMapping("test/response/body")
    @ResponseBody
    public Item responseBody(HttpServletRequest request, HttpServletResponse response) {
        // http://localhost:8080/mvc/test/response/body?id=3&name=haha&price=89.1
        Item item = new Item();
        item.setName(request.getParameter("name"));
        item.setId(Integer.parseInt(request.getParameter("id")));
        item.setPrice(Float.parseFloat(request.getParameter("price")));

//        response.setContentType("application/json");

        return item;
    }

    @RequestMapping("test/model/attribute")
    public String modelAttribute(ModelMap model) {
        System.out.println("test/model/attribute");
        Object map = model.get("map");
        return "ok";
    }
    
    // URI是唯一的, 重复的会报错
//    @RequestMapping("test/model/attribute")
//    public void modelAttribute2(ModelMap model) {
//        System.out.println("modelAttribute2");
//    }

    @ModelAttribute
    public void map() {
        System.out.println("ModelAttribute in SpringMVCController");
    }


}
