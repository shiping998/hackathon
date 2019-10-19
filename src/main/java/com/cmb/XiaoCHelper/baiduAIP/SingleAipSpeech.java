package com.cmb.XiaoCHelper.baiduAIP;

import com.baidu.aip.speech.AipSpeech;

public class SingleAipSpeech {

    public static final String APPID = "17552375";
    public static final String APPKEY = "RfXM5UwkSpdaveyB1sfgLkyM";
    public static final String SECRETKEY = "c2s1jjAfld0p7dxZceyZt2g4ncfsF1l9";

    private static AipSpeech aipSpeech = new AipSpeech(APPID,APPKEY ,SECRETKEY );

    public static AipSpeech getInstance(){
        return aipSpeech;
    }
}
