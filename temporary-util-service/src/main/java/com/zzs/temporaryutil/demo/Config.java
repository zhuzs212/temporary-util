package com.zzs.temporaryutil.demo;

public interface Config {

    // 推荐：用 private static 方法初始化
    int TIMEOUT = initTimeout();
    String URL = initUrl();

    static int initTimeout() {
        System.out.println("初始化 TIMEOUT");
        return 30;
    }

    static String initUrl() {
        System.out.println("初始化 URL");
        return "https://api.example.com";
    }

    // 可选：静态工具方法
    static void printConfig() {
        System.out.println("Config: timeout=" + TIMEOUT + ", url=" + URL);
    }
}

// 测试类
class Main {
    public static void main(String[] args) {
        Config.printConfig(); // 触发初始化
    }
}