package com.thread.day20201103;

import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

// 安全集合测试 CopyOnWriteArrayList
public class ListTest {

    public static void main(String[] args)  {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
//        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add("你好" + i);
        }

        System.out.println(list.toString());

        for (String string: list) {

            if(string.equals("你好2")) {
                list.remove(string);
            }
        }

        ListIterator<String> iterator = list.listIterator();
        StringBuilder stringBuilder = new StringBuilder();

        while (iterator.hasNext()) {
           stringBuilder.append(iterator.next());
        }

        System.out.println(list.toString());
        System.out.println(stringBuilder.toString());
    }
}
