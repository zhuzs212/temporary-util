package com.zzs.temporaryutil.demo;

import java.util.Arrays;
import java.util.List;

public class StreamLazyDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Tom", "Jerry", "Spike");

        System.out.println("创建 Stream，但还没开始执行任何操作...");

        // 这里定义了一串操作（中间操作）
        var stream = list.stream()
                .filter(s -> {
                    System.out.println("执行 filter：" + s);
                    return s.length() > 3;
                })
                .map(s -> {
                    System.out.println("执行 map：" + s);
                    return s.toUpperCase();
                });

        System.out.println("此时还没任何输出（说明没有执行）！");
        System.out.println("----- 开始终止操作 forEach()，此时才真正执行 -----");

        // 只有终止操作时才触发整个计算链执行
        stream.forEach(s -> System.out.println("最终结果：" + s));
    }
}