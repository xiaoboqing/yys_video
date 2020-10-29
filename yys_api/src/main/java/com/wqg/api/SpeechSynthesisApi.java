package com.wqg.api;

import com.wqg.utils.SpeechSynthesisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 语音合成接口
 */
@Controller
@Api(value = "语音合成模块")
public class SpeechSynthesisApi {

    @RequestMapping(value="/speechSysnthesis", method = RequestMethod.POST)
    @ApiOperation(value = "上传语音文件 ", notes = "用户上传语音文件")
    public void speechSysnthesis(@ApiParam(value = "上传语音文件", required = true) MultipartFile files, HttpServletResponse response) throws Exception {

        StringBuilder txtContent = new StringBuilder();
        File file = null;
        file = File.createTempFile("tmp", null); //创建临时文件
        files.transferTo(file); //MultipartFile转File
        file.deleteOnExit(); //虚拟机运行结束后删除临时文件
        BufferedReader reader = null;
        String temp = null;
        int line = 1;
        try {
            int result = 0;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//解决服务器上乱码
            while ((temp = reader.readLine()) != null) {
                txtContent.append(temp);
                line++;
            }
//            SpeechSynthesisUtil.doTts(txtContent.toString(), response);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 后台语音合成接口
     * @param tex 语音文本
     * @param response
     * @param type 合成文件类型
     * @throws Exception
     */
    @ApiOperation(value = "语音合成 ", notes = "输入文字")
    @RequestMapping(value="/speechSysnthesis", method = RequestMethod.GET)
    public void speechSysnthesis(@ApiParam(value = "输入合成语音的文字", required = true)@RequestParam("tex") String tex, HttpServletResponse response, @RequestParam(value = "type", defaultValue = "mp3") String type) throws Exception {
        SpeechSynthesisUtil.doTts(tex, response, type);

    }
}
