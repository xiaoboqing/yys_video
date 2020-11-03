package com.thread.day20201102;

/**
 * 生产者消费者问题
 */
public class TestPC {
    public static void main(String[] args) {
        SynContair synContair = new SynContair();
        new Consumer(synContair).start();
        new Productor(synContair).start();


    }
}

// 消费者

class Consumer extends Thread{

    private SynContair synContair;

   public Consumer(SynContair synContair) {
       this.synContair = synContair;
   }

    @Override
    public void run() {
        // 从缓存中取出物品
        for (int i = 1; i < 100; i ++) {
            Chicken chicken = synContair.pop();
            System.out.println("消费者消费了第" + chicken.getId() + "鸡");
        }
    }
}

// 生产者

class Productor extends  Thread{

    private SynContair synContair;

    public Productor(SynContair synContair) {
        this.synContair = synContair;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i ++) {
            System.out.println("生产者生产了第" + i + "鸡");
            synContair.push(new Chicken(i));

        }
    }
}

// 产品

class Chicken {
    private int id;

    public Chicken(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

// 缓存区

class SynContair {

    // 定义一个大小为10的缓存区
    private Chicken[] chickens = new Chicken[10];
    // 计数器
    private int count = 0;

    // 向缓存中添加商品

    synchronized void push(Chicken chicken) {

        // 判断缓存是否满了

        if( count == chickens.length) {
            // 停止生产
            try{
                this.wait();
            }catch (Exception e) {

            }
        }

        // 生产商品
        chickens[count] = chicken;
        count ++;

        this.notifyAll();


    }

    // 从缓存中取出商品
   synchronized Chicken pop() {

        // 判断缓存中是否有商品
        if (count == 0) {
            // 停止消费，通知生产者生产
            try {
                this.wait();
            }catch (Exception e) {

            }
        }

        count --;
        Chicken chicken = chickens[count];

        // 通知生产者生产
        this.notifyAll();

        return chicken;

    }
}
