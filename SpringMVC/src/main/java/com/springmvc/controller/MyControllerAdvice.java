package com.springmvc.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前把返回值放入ModelMap中
     */
//    @ModelAttribute
//    public Map<String, Object> map() {
//        System.out.println("ModelAttribute in MyControllerAdvice");
//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "tom");
//        return map;
//    }

    /**
     * 应用到所有【带参数】的@RequestMapping注解方法，在其执行之前初始化数据绑定器
     */
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        System.out.println("initBinder...");
    }

    /**
     * 应用到所有@RequestMapping注解的方法，在其抛出指定异常时执行
     * 可以做一些异常处理, 例如转到一个专门显示异常的页面
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        System.out.println("handleException...");
        return "exception";
//        return e.getMessage();
    }

}
