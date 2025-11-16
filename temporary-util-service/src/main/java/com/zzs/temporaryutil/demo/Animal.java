package com.zzs.temporaryutil.demo;

abstract class Animal {
    // 实例变量
    String name;

    // 实例初始化块（每次 new 时执行）
    {
        System.out.println("【实例块】正在创建 Animal 实例");
        name = "Unknown";
    }

    // 静态变量
    static String kingdom;

    // 静态初始化块（类加载时执行一次）
    static {
        System.out.println("【静态块】Animal 类被加载");
        kingdom = "Animalia";
    }

    // 构造器
    Animal() {
        System.out.println("【构造器】Animal()");
    }

    abstract void sound();
}

class Test {
    public static void main(String[] args) {
        System.out.println("--- 开始创建对象 ---");
        new Animal() {
            @Override void sound() { System.out.println("..."); }
        };
    }
}