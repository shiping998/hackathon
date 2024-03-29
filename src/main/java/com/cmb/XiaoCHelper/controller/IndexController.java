package com.cmb.XiaoCHelper.controller;

import com.alibaba.fastjson.JSONObject;
import com.cmb.XiaoCHelper.model.Rtn;
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
    public Rtn TextController(@RequestBody JSONObject jsonParam){
        String text=jsonParam.get("text").toString();
        System.out.println("前端传来文字："+text);
        Rtn rtn = new Rtn();
        Map<String,String> map = new HashMap<String,String>();
        map.put("text", text);
        //直接发送text
        try{
            String result=HttpClient.sendJSONPostRequest(url,map);
            JSONObject jsonObject = JSONObject.parseObject(result);
            System.out.println("数据端返回："+jsonObject);
            rtn.setRtn_cod("200");
            rtn.setRtn_msg("success");
            rtn.setResult(jsonObject);
            return rtn;
        }catch (Exception e){
            e.printStackTrace();
            rtn.setRtn_cod("500");
            rtn.setRtn_msg("error");
            rtn.setResult(null);
            return rtn;
        }
    }
}
