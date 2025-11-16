package com.zzs.temporaryutil.demo;

import java.util.Arrays;
import java.util.List;
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("C", "a", "b");

        // 旧写法：匿名内部类
        list.sort(new java.util.Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        // 新写法：Lambda
        list.sort((a, b) -> a.compareTo(b));

        System.out.println(list); // [a, b, c]

    }
}