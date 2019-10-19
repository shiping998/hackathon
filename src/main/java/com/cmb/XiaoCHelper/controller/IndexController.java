package com.cmb.XiaoCHelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/index")
    String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/User")
    Map User(){

        Map<String,String> map = new HashMap<String,String>();
        map.put("username", "王天放");
        map.put("userage", "25");
        return map;
    }
}
