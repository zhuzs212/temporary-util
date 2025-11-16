package com.zzs.temporaryutil.demo;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        // 场景1：延迟加载 - 只有调用 get() 才执行
        Supplier<HeavyObject> supplier = () -> {
            System.out.println("正在创建重量级对象...");
            return new HeavyObject();
        };

        System.out.println("supplier 已创建，但对象未构造");

        // 只有这里才真正创建对象
        HeavyObject obj = supplier.get();
        obj.sayHello();
    }
}

class HeavyObject {
    public HeavyObject() {
        // 模拟耗时构造
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println("对象未构造完成");
    }

    public void sayHello() {
        System.out.println("Hello from HeavyObject!");
    }
}