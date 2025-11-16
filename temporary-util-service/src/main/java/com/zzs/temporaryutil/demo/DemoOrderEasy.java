package com.zzs.temporaryutil.demo;

class Parent {
    static int staticVarParent = log("① [父类] 静态变量初始化");
    static { log("② [父类] 静态代码块"); }

    int instanceVarParent = log("⑤ [父类] 实例变量初始化");
    { log("⑥ [父类] 实例代码块"); }

    Parent() {
        log("⑦ [父类] 构造器");
    }

    static int log(String msg) {
        System.out.println(msg);
        return 0;
    }
}

class Child extends Parent {
    static int staticVarChild = log("③ [子类] 静态变量初始化");
    static { log("④ [子类] 静态代码块"); }

    int instanceVarChild = log("⑧ [子类] 实例变量初始化");
    { log("⑨ [子类] 实例代码块"); }

    Child() {
        log("⑩ [子类] 构造器");
    }
}

public class DemoOrderEasy {
    public static void main(String[] args) {
        System.out.println("———— main 开始 ————");
        new Child();
        System.out.println("———— 再次 new Child() ————");
        new Child();
    }
}
