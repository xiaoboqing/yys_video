package com.thread.day20201030;

/**
 * 实现多线程方式二：实现Runnable接口
 *
 */


public class MyRunnable implements Runnable{

    private String url;
    private String name;

    public MyRunnable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader.downLoader(url, name);
        System.out.println("下载网络图片名称---" + name);
    }
}
