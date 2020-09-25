package com.aiwenbin.reflection.peoject01;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Ref;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) {

//        1. 加载并解析配置文件
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("application.properties");
        try {
            properties.load(resourceAsStream);
            String className = properties.getProperty("className");
            String methName = properties.getProperty("methName");

            Class cls = Class.forName(className);
            Object o = cls.newInstance();
            Method method = cls.getMethod(methName);
            method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
