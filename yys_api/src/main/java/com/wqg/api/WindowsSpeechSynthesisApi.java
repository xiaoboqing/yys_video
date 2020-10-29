package com.wqg.api;

import com.wqg.utils.SpeechSynthesis;
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

@Controller
@Api(value = "语音合成模块Windows版")
public class WindowsSpeechSynthesisApi {

    @RequestMapping(value="/windows", method = RequestMethod.GET)
    @ApiOperation(value = "输入语音文本 ", notes = "输入语音文本")
    public void speechSysnthesis(@ApiParam(value = "输入合成语音的文字", required = true)@RequestParam("tex") String tex, @ApiParam(value = "输入用户id", required = true)@RequestParam("userId")String userId, HttpServletResponse response, @RequestParam(value = "type", defaultValue = "mp3") String type) throws Exception {
        SpeechSynthesis.textToSpeech(tex, userId,response, type );
    }
}
