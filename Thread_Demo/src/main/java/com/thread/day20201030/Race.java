package com.thread.day20201030;

// 定义跑道
public class Race implements Runnable {

    private static String winner;

    @Override
    public void run() {

       for (int i = 0; i <= 100; i ++) {

           if (end(i)) {
               break;
           }

           System.out.println(Thread.currentThread().getName() + "--->跑了"+ i + "米");

       }

    }

    // 判断是否有结束
    public boolean end(int step) {

        if (winner == null) {
            if (step == 100) {
                winner = Thread.currentThread().getName();
                System.out.println(Thread.currentThread().getName() + "赢了比赛");
                return true;
            }
        }else{
            return true;
        }

        return false;
    }

}
