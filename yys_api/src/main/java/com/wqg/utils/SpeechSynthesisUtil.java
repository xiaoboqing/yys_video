package com.wqg.utils;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/**
 * @Author wangqinguang
 * @Description 语音合成工具类
 * @Date 2020/10/19
 */
public class SpeechSynthesisUtil {

    public interface MyDllInterface extends Library {
        // Linux
        //MyDllInterface INSTANCE = (MyDllInterface) Native.loadLibrary("msc", MyDllInterface.class);
        // Windows
        MyDllInterface INSTANCE = (MyDllInterface)Native.loadLibrary("msc_x64", MyDllInterface.class);

        public int MSPLogin(String usr, String pwd, String params);
        String QTTSSessionBegin(String params, IntByReference errorCode);
        public int QTTSTextPut(String sessionID, String textString, int textLen, String params);
        Pointer QTTSAudioGet(String sessionID, IntByReference audioLen, IntByReference synthStatus,
                             IntByReference errorCode);
        public int QTTSSessionEnd(String sessionID, String hints);
        public int MSPLogout();
    }

    /**
     * 语音合成核心方法
     * @param text 合成文字
     * @param suffixes 合成文件类型
     * @param response 响应头
     * @throws Exception
     */
    public static void doTts(String text, HttpServletResponse response, String suffixes) throws Exception{

        OutputStream os = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        IntByReference retOneIntByReference = null;
        String sessionID = null;
        String login_params = "appid = 5f852bdc";
        String path_common = System.getProperty("user.dir")+"/common.jet";
        String path_xiaoyan = System.getProperty("user.dir")+"/xiaoyan.jet";
        String session_begin_params = "engine_type = local, voice_name = xiaoyan, text_encoding = UTF8, " +
                "tts_res_path = fo|"+path_xiaoyan+";fo|" + path_common +
                ", sample_rate = 16000, speed = 50, volume = 50, pitch = 50, rdn = 2";
        // 合成的语音文件名称
        String filename = "sample." + suffixes;

        try{

            int ret = MyDllInterface.INSTANCE.MSPLogin(null, null, login_params);
            if (0!= ret)
            {
                System.out.println("MSPLogin failed, error code: %d.\n"+ret);
            }

            retOneIntByReference = new IntByReference(-1);
            sessionID = MyDllInterface.INSTANCE.QTTSSessionBegin(session_begin_params,retOneIntByReference);
            // text.length()*3
            ret= MyDllInterface.INSTANCE.QTTSTextPut(sessionID, text, text.getBytes().length, null);

            int audio_len=1280;
            int synth_status=1;

            IntByReference audioLenIntByReference = new IntByReference(0);
            IntByReference synthStatusIntByReference = new IntByReference(1);
            byteArrayOutputStream = new ByteArrayOutputStream(96000);
            int totalAudioLength = 0;
            int indexFlag=0;
            int num = 0;
            Integer max = 99;

            while (true) {
                Pointer dataPoint = MyDllInterface.INSTANCE.QTTSAudioGet(sessionID,audioLenIntByReference,
                        synthStatusIntByReference,retOneIntByReference);
                if (0!= ret){
                    break;
                }
                byte[] dataByteAudio;
                if (dataPoint!=null ){
                    dataByteAudio = dataPoint.getByteArray(0, audioLenIntByReference.getValue());
                    byteArrayOutputStream.write(dataByteAudio,0,audioLenIntByReference.getValue());
                    indexFlag=indexFlag+audioLenIntByReference.getValue();
                    totalAudioLength=totalAudioLength+audioLenIntByReference.getValue();
                }
                if (synthStatusIntByReference.getValue()==2){
                    break;
                }
            }

            byteArrayOutputStream.flush();

            WaveHeader.DataSize = WaveHeader.revers(WaveHeader.intToBytes(totalAudioLength));
            WaveHeader.RIFF_SIZE = WaveHeader.revers(WaveHeader.intToBytes(totalAudioLength + 36 - 8));
            String fileName = "sample." + suffixes;
            os = response.getOutputStream();
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            response.setHeader("fileName",fileName);
            response.setHeader("Content-Type","audio/"+suffixes);
            response.setHeader("Access-Control-Expose-Headers","fileName");
            WaveHeader.init();
            os.write(WaveHeader.RIFF);
            os.write(WaveHeader.RIFF_SIZE);
            os.write(WaveHeader.RIFF_TYPE);
            os.write(WaveHeader.FORMAT);
            os.write(WaveHeader.FORMAT_SIZE);
            os.write(WaveHeader.FORMAT_TAG);
            os.write(WaveHeader.CHANNELS);
            os.write(WaveHeader.SamplesPerSec);
            os.write(WaveHeader.AvgBytesPerSec);
            os.write(WaveHeader.BlockAlign);
            os.write(WaveHeader.BitsPerSample);
            os.write(WaveHeader.Data);
            os.write(WaveHeader.DataSize);
            os.write(byteArrayOutputStream.toByteArray());

            os.flush();

        } finally {

            if(!ObjectUtils.isEmpty(byteArrayOutputStream)) {
                byteArrayOutputStream.close();
            }

            if (!ObjectUtils.isEmpty(os)) {
                os.close();
            }

            if (!ObjectUtils.isEmpty(retOneIntByReference)) {
                retOneIntByReference.setValue(MyDllInterface.INSTANCE.QTTSSessionEnd(sessionID, "正常退出"));
                //退出
                MyDllInterface.INSTANCE.MSPLogout();
            }
        }
    }
}
