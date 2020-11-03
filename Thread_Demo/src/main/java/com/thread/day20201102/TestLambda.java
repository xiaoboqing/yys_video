package com.thread.day20201102;

/**
 * Lambda表达式
 * 1.函数式接口
 */
public class TestLambda {
    public static void main(String[] args) {
        Test test = ()-> System.out.println("你好");
        test.ou();
    }
}

interface Test {
    void ou ();
}

