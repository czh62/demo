package com.example.demo.utils;

/**
 * ThreadLocal为每个线程单独提供一份存储空间，具有线程隔离的效果，只有在线程内才能获取到对应的值，线程外则不能访问。
 * 将ThreadLocal进行封装，便于代码的维护和迭代
 */
public class BaseContext {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setCurrentToken(String Token) {
        threadLocal.set(Token);
    }

    public static String getCurrentToken() {
        return threadLocal.get();
    }

    public static void removeCurrentToken() {
        threadLocal.remove();
    }

}