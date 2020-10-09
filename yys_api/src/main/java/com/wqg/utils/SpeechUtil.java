package com.wqg.utils;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SpeechUtil {


    public static final String APP_ID = "22795710";

    public static final String API_KEY = "2cL2iWw68ULaRxf8s9oXNYn8";

    public static final String SECRET_KEY = "3YmszMSwEuBY9DkKGcXykCnppP7Ur9tU";

    private static AipSpeech client;

    public static void main(String[] args) throws IOException {
        String  str = "30分钟前，由北京市顺义区二经路与二纬路交汇处北侧，北京首都国际机场T3航站楼 去往 东城区北三环东路36号喜来登大酒店(北京金隅店);" +
                "30分钟前，由北京市顺义区二经路与二纬路交汇处北侧，北京首都国际机场T3航站楼 去往 东城区北三环东路36号喜来登大酒店(北京金隅店) "+
                "30分钟前，由北京市顺义区二经路与二纬路交汇处北侧，北京首都国际机场T3航站楼 去往 东城区北三环东路36号喜来登大酒店(北京金隅店)";
        SpeechSynthesizer(str, "f:/SpeechSynthesizer.mp3");
    }


    /**
     * 单例 懒加载模式 返回实例
     * @return
     */
    public static AipSpeech getInstance(){
        if (client==null){
            synchronized (AipSpeech.class){
                if (client==null) {
                    client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return client;
    }

    /**
     * 语音合成
     * @param word 文字内容
     * @param outputPath 合成语音生成路径
     * @return
     */
    public static boolean SpeechSynthesizer(String word, String outputPath) {
        /*
        最长的长度
         */
        int maxLength = 1024;
        if (word.getBytes().length >= maxLength) {
            return false;
        }
        // 初始化一个AipSpeech
        client = getInstance();

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        HashMap<String, Object> map = new HashMap<>();
//        map.put("vol", 9); //音量
//        map.put("pit", 5);  //声音人
//        map.put("spd", 5);  //语速
//        map.put("per", 1); //语调
        // 调用接口
        TtsResponse res = client.synthesis(word, "zh", 1, null);
        byte[] data = res.getData();
        org.json.JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, outputPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        if (res1 != null) {
            log.info(" result : " + res1.toString());
        }
        return false;

    }
}
