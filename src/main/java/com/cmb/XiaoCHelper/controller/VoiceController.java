package com.cmb.XiaoCHelper.controller;

import com.baidu.aip.speech.AipSpeech;
import com.cmb.XiaoCHelper.baiduAIP.SingleAipSpeech;
import com.cmb.XiaoCHelper.model.Rtn;
import com.cmb.XiaoCHelper.utils.HttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@RestController
public class VoiceController {

    @RequestMapping("/uploadVoice")
    public Rtn singleVoiceUpload(@RequestParam("file") MultipartFile file) {
        Rtn rtn = new Rtn();

        if (file.isEmpty()) {
            rtn.setRtn_cod("500");
            rtn.setRtn_msg("Voice File is Empty,Check!");
            return rtn;
        }

        try {
            // Get the file
            byte[] bytes = file.getBytes();
            System.out.println("文件名："+file.getOriginalFilename());
            System.out.println("文件大小："+file.getSize());
            //语音转换
            AipSpeech client = SingleAipSpeech.getInstance();
            // 调用接口
            JSONObject res = client.asr(bytes, "pcm", 16000, null);
            System.out.println(res);

            try {
                JSONArray arr = (JSONArray)res.get("result");
                System.out.println(arr.get(0));
                Map<String, String> map = new HashMap<>();
                String text = (String)arr.get(0);
                text = text.substring(0, 6);
                map.put("text", text);

                rtn.setResult(map);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rtn;
    }
}
