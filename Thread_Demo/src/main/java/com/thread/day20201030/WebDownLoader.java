package com.thread.day20201030;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

// 下载网络图片工具类
public class WebDownLoader {

    // 下载方法
    public static void downLoader(String url, String name) {

        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
