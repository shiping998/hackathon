package com.cmb.XiaoCHelper;

import com.baidu.aip.speech.AipSpeech;
import com.cmb.XiaoCHelper.baiduAIP.SingleAipSpeech;
import com.cmb.XiaoCHelper.utils.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class unitTest {

    @Test
    public void out(){

        System.out.println("测试");
    }

    @Test
    public void voice(){
        AipSpeech client = SingleAipSpeech.getInstance();
//        String path = "C:\\计科学习\\JavaPrj\\xiaochelper\\zy-2901ms-16kbps-16000hz.wav";
        String path = "C:\\计科学习\\JavaPrj\\xiaochelper\\recodertest.pcm";
        // 调用接口
        JSONObject res = client.asr(path, "wav", 16000, null);
        System.out.println(res);

    }

    @Test
    public void sendAndRec(){
        AipSpeech client = SingleAipSpeech.getInstance();
        String path = "C:\\计科学习\\JavaPrj\\xiaochelper\\zy-2901ms-16kbps-16000hz.wav";
        // 调用接口
        JSONObject res = client.asr(path, "wav", 16000, null);
        System.out.println(res);

        try {
            JSONArray arr = (JSONArray)res.get("result");
            System.out.println(arr.get(0));
            Map<String, String> map = new HashMap<>();
            String text = (String)arr.get(0);
            text = text.substring(0, 6);
//            System.out.println(text);
            text = "百度";
            map.put("text", text);
            String s = HttpClient.sendJSONPostRequest("http://99.15.215.14:8080/url", map);
            System.out.println(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
