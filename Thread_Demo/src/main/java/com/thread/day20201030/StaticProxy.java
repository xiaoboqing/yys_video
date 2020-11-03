package com.thread.day20201030;

/**
 * 静态代理模式
 * 1.定义一个公共接口
 * 2.写目标类和代理类分别实现这个接口
 * 3.在代理类中写一个构造器将目标类传入
 */
public class StaticProxy {

    public static void main(String[] args) {
        new WeddingCompany(new My()).happyMarry();
    }



}


//定义一个公共接口

interface Marry{
    // 定义一个抽象方法
    void happyMarry();
}

// 定义一个真实对象类 实现公共接口

class My implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("结婚了，很高兴");
    }
}

// 定义一个代理类 实现公共接口
class WeddingCompany implements Marry {

    // 生命目标对象
    private Marry target;

   public WeddingCompany(Marry target) {
        this.target = target;
    }
    public WeddingCompany() {
    }
    @Override
    public void happyMarry() {
        befer();
        target.happyMarry();
        after();
    }

    void befer() {
        System.out.println("婚场布局");
    }

    void after() {
        System.out.println("收尾款");
    }
}

