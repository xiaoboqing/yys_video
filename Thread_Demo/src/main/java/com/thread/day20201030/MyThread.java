package com.thread.day20201030;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

/**
 * 实现多线程方式一：继承Thread类
 */

public class MyThread extends Thread {

    private String url;
    private String name;

    public MyThread (String url, String name) {
        this.url = url;
        this.name =name;
    }

    // 重写run方法
   @Override
    public void run () {
        WebDownLoader.downLoader(url, name);
       System.out.println("下载网络图片名称---" + name);
    }

    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("https://goss.cfp.cn/creative/vcg/800/version23/VCG21gic7217056.jpg?" +
                "x-oss-process=image/format,jpg/interlace,1","1.jpg");
        MyThread myThread2 = new MyThread("https://goss.cfp.cn/creative/vcg/800/version23/VCG21gic7217056.jpg?" +
                "x-oss-process=image/format,jpg/interlace,1","2.jpg");
        MyThread myThread3 = new MyThread("https://goss.cfp.cn/creative/vcg/800/version23/VCG21gic7217056.jpg?" +
                "x-oss-process=image/format,jpg/interlace,1","3.jpg");

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }



}
