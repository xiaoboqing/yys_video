package com.thread.day20201030;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者问题：未处理并发情况
 */
public class ProductAndConsumer implements Runnable {

    // 声明一百张票
    private  int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    // 购票方法
    @Override
    public  void run() {
        while (ticket > 0) {
            try {
                lock.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "----->购买了第 " + ticket -- + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

    }


    public static void main(String[] args) {

        ProductAndConsumer productAndConsumer = new ProductAndConsumer();

        // 开启两个线程
        new Thread(productAndConsumer, "小明").start();
        new Thread(productAndConsumer, "小qing").start();
    }
}
