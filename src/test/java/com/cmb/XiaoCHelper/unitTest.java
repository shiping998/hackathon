package com.cmb.XiaoCHelper;

import com.baidu.aip.speech.AipSpeech;
import com.cmb.XiaoCHelper.baiduAIP.SingleAipSpeech;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class unitTest {

    @Test
    public void out(){

        System.out.println("测试");
    }

    @Test
    public void voice(){
        AipSpeech client = SingleAipSpeech.getInstance();
        String path = "C:\\计科学习\\JavaPrj\\xiaochelper\\zy-2901ms-16kbps-16000hz.wav";
        // 调用接口
        JSONObject res = client.asr(path, "wav", 16000, null);
        System.out.println(res);

    }


}
