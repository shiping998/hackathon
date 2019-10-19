package com.cmb.XiaoCHelper.utils;
import com.alibaba.fastjson.JSONObject;
public class XiaoCHelperUtil {
    public static String getJSONString(String code, String msg,Object result) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        json.put("result",result);
        return json.toJSONString();
    }

    public static JSONObject getJSONObject(String st) {
        JSONObject json = new JSONObject();
        json.put("text", st);
        return json;
    }
}
