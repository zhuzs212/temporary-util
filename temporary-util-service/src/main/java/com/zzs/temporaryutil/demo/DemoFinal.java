package com.zzs.temporaryutil.demo;

class ConstTest {
    // 编译期常量（primitive 或 String 字面量）——可被内联
    public static final int COMPILE_TIME_INT = 100;
    public static final String COMPILE_TIME_STR = "HELLO";

    // 运行期常量（运行方法或 new 对象初始化）——不会被内联
    public static final int RUNTIME_INT = initInt();
    public static final String RUNTIME_STR = new String("HELLO_RUNTIME");

    static {
        System.out.println("【ConstTest 静态块】类初始化");
    }

    private static int initInt() {
        System.out.println("initInt() 被执行");
        return 200;
    }
}

public class DemoFinal {
    public static void main(String[] args) {
        System.out.println("main 开始");
        // 访问编译期常量（不会触发类初始化）
        System.out.println(ConstTest.COMPILE_TIME_INT);
        System.out.println(ConstTest.COMPILE_TIME_STR);
        System.out.println("-------------------");
        // 访问运行期常量（会触发类初始化）
        System.out.println(ConstTest.RUNTIME_INT);
        System.out.println(ConstTest.RUNTIME_STR);
    }
}
