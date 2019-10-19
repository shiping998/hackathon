package com.cmb.XiaoCHelper.util;
import com.alibaba.fastjson.JSONObject;
public class XiaoCHelperUtil {
    public static String getJSONString(String code, String msg,Object result) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", msg);
        json.put("result",result);
        return json.toJSONString();
    }
}
