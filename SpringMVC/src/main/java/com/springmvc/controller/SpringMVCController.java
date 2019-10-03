package com.springmvc.controller;

import com.springmvc.po.Item;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SpringMVCController {

    private static Logger log = Logger.getLogger(SpringMVCController.class);

//    @RequestMapping("test/show/param")
//    public String test(HttpServletRequest request, ModelAndView modelAndView) {
//        // http://localhost:8080/mvc/test/show/param?id=3&name=haha&price=89.1
//        Item item = new Item();
//        item.setId(Integer.parseInt(request.getParameter("id")));
//        item.setName(request.getParameter("name"));
//        item.setPrice(Float.parseFloat(request.getParameter("price")));
//
//        modelAndView.addObject("item", item);
//        System.out.println(1 / 0);
//
//        return "showParam"; //这个页面好像不是展示的, 而是用来测试post提交的
//    }

//    @RequestMapping("test/response/body")
//    @ResponseBody
//    public Item responseBody(HttpServletRequest request, HttpServletResponse response) {
//        // http://localhost:8080/mvc/test/response/body?id=3&name=haha&price=89.1
//        Item item = new Item();
//        item.setName(request.getParameter("name"));
//        item.setId(Integer.parseInt(request.getParameter("id")));
//        item.setPrice(Float.parseFloat(request.getParameter("price")));
//
////        response.setContentType("application/json");
//
//        return item;
//    }

    @RequestMapping(value = "test/model/attribute", method = RequestMethod.GET)
    @ResponseBody
    public Item modelAttributeGet(ModelMap model, Integer id, Item item, HttpServletRequest request) {
        System.out.println("test/model/attribute GET method");
//        Object map = model.get("map");
        System.out.println("id from method args = " + id);
        String id1 = request.getParameter("id");
        System.out.println("id from request = " + id1);
        return item;
    }

    // URI是唯一的, 重复的会报错
//    @RequestMapping("test/model/attribute")
//    public void modelAttribute2(ModelMap model) {
//        System.out.println("modelAttribute2");
//    }

    @RequestMapping(value = "test/model/attribute", method = RequestMethod.POST)
    public String modelAttributePost(ModelMap model) {
        System.out.println("test/model/attribute POST method");
        Object map = model.get("map");
        return "ok";
    }

//    @ModelAttribute
//    public void map() {
//        System.out.println("ModelAttribute in SpringMVCController");
//    }


}
