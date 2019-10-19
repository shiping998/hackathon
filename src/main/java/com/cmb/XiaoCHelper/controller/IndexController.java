package com.cmb.XiaoCHelper.controller;

import com.cmb.XiaoCHelper.utils.XiaoCHelperUtil;
import com.cmb.XiaoCHelper.utils.HttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    private static String url="http://99.15.215.14:8080/url";

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
    @RequestMapping("/Text")
    public String TextController(@RequestParam("text") String text){
        Map<String,String> map = new HashMap<String,String>();
        map.put("text", text);
        //直接发送text
        String result=HttpClient.sendJSONPostRequest(url,map);
        return XiaoCHelperUtil.getJSONString("0","success",result);

    }
}
