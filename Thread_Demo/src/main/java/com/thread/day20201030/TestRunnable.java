package com.thread.day20201030;

public class TestRunnable {

    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable("https://goss.cfp.cn/creative/vcg/800/version23/VCG21gic7217056.jpg?" +
                "x-oss-process=image/format,jpg/interlace,1", "1.jpg");
        MyRunnable myRunnable2 = new MyRunnable("https://goss.cfp.cn/creative/vcg/800/version23/VCG21gic7217056.jpg?" +
                "x-oss-process=image/format,jpg/interlace,1", "2.jpg");
        MyRunnable myRunnable3 = new MyRunnable("https://goss.cfp.cn/creative/vcg/800/version23/VCG21gic7217056.jpg?" +
                "x-oss-process=image/format,jpg/interlace,1", "3.jpg");

        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable3).start();
    }
}
