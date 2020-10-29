package com.wqg.utils;


import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文字转语音测试 jdk bin文件中需要导入jacob-1.17-M2-x64.dll
 *
 * @author zk
 * @date: 2019年6月25日 上午10:05:21
 */
public class SpeechSynthesis {

    public static void main(String[] args) {
//        textToSpeech("你好，语音合成测试已开始请准备12.20元", "002");
    }
    /**
     * 语音转文字并播放
     */
    public static void textToSpeech(String text, String userId, HttpServletResponse response, String type) {
        ActiveXComponent ax = null;
        Dispatch spAudioFormat = null;
        Dispatch spFileStream = null;
        Dispatch spVoice = null;
        BufferedReader reader = null;
        File file = null;

        try {
            ax = new ActiveXComponent("Sapi.SpVoice");
            String fileName = userId +  "_voide";
            String fileType = fileName + "." + type;
            String patch = "C:/test/"+ fileType;

            // 运行时输出语音内容
            spVoice = ax.getObject();

            ax = new ActiveXComponent("Sapi.SpFileStream");
            spFileStream = ax.getObject();

            ax = new ActiveXComponent("Sapi.SpAudioFormat");
            spAudioFormat = ax.getObject();

            // 设置音频流格式
            Dispatch.put(spAudioFormat, "Type", new Variant(22));
            // 设置文件输出流格式
            Dispatch.putRef(spFileStream, "Format", spAudioFormat);
            // 调用输出 文件流打开方法，创建一个.wav文件
            String path_common = System.getProperty("user.dir") ;

            Dispatch.call(spFileStream, "Open", new Variant(patch), new Variant(3), new Variant(true));
            // 设置声音对象的音频输出流为输出文件对象
            Dispatch.putRef(spVoice, "AudioOutputStream", spFileStream);
            // 设置音量 0到100
            Dispatch.put(spVoice, "Volume", new Variant(100));
            // 设置朗读速度
            Dispatch.put(spVoice, "Rate", new Variant(-2));
            // 开始朗读
            Dispatch.call(spVoice, "Speak", new Variant(text));
            Dispatch.call(spFileStream, "Close");
            spAudioFormat.safeRelease();
            spFileStream.safeRelease();
            spVoice.safeRelease();
            ax.safeRelease();
            System.out.println(patch);
            System.out.println(fileType);
            System.out.println(fileName);
            InputStream inStream = new FileInputStream(patch);// 文件的存放路径
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            response.setHeader("fileName",fileName);
            response.setHeader("Content-Type","audio/"+type);
            response.setHeader("Access-Control-Expose-Headers","fileName");
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[100];
            int len;
            while ((len = inStream.read(b)) > 0)
                os.write(b, 0, len);
            inStream.close();
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

