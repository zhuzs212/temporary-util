package com.zzs.temporaryutil.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 此工具类用于从Spring的上下文中去获取到类，解决@autowird注入空指针的问题（1、不能在定时任务中调用别的类 2、不能new一个类。）
 *
 * 初始化顺序：
 * 成员变量初始化 -> Constructor -> @Autowired
 * @author zhuzs
 * @date 2022/7/27 10:25
 */
@Component
public class ApplicationContextHelperUtil implements ApplicationContextAware {
    private static ApplicationContext applCon;
    /**
     * 为空时，设置实例
     */
    @Override
    public void setApplicationContext(ApplicationContext applCon) throws BeansException {
        if (ApplicationContextHelperUtil.applCon == null) {
            ApplicationContextHelperUtil.applCon = applCon;
        }
    }

    /**
     * 获取applicationContext的实例applCon
     */
    public static ApplicationContext getApplicationContext() {
        return applCon;
    }

    /**
     * 通过name,以及Clazz获取指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 通过clazz获取Bean（推荐使用这种）
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name获取 Bean
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
}