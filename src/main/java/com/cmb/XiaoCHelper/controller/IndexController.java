package com.cmb.XiaoCHelper.controller;

import com.alibaba.fastjson.JSONObject;
import com.cmb.XiaoCHelper.utils.XiaoCHelperUtil;
import com.cmb.XiaoCHelper.utils.HttpClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
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
    @RequestMapping(path = {"/text"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public JSONObject TextController( String text){
        Map<String,String> map = new HashMap<String,String>();
        map.put("text", text);
        //直接发送text
        try{
            String result=HttpClient.sendJSONPostRequest(url,map);
            return XiaoCHelperUtil.getJSONObject("0","success",result);
        }catch (Exception e){
            return XiaoCHelperUtil.getJSONObject("500","error",null);
        }
    }
}
