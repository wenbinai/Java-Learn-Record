package com.aiwenbin.reflection;

import java.lang.reflect.Field;

public class ClassDemo02 {
    public static void main(String[] args) {
        /**
         * Class 类常见的用法
         */

        Class clazz = TypeDemo01.class;
//        1. 获取类的名字
        String clazzName = clazz.getName();
        System.out.println(clazzName);

        System.out.println("----");

//        2. 获取公开的成员变量
        Field[] fields = clazz.getFields();
        for(Field field : fields) {
            System.out.println(field);
        }

        System.out.println("----");
//        3. 获取全部的成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }

        System.out.println("----");

//        4. 获取注解
//        5. 获取构造方法

    }
}
