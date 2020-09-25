package com.aiwenbin.reflection;

public class ClassDemo01 {
    public static void main(String[] args) {
        /**
         * 1. 获取TypeDemo01类的三种方法
         */
        try {
//            1. 通过Class.forName()获取
            Class clazz1 = Class.forName("com.aiwenbin.reflection.TypeDemo01");
            System.out.println(clazz1);
//            2. 通过类名.class获取
            Class clazz2 = TypeDemo01.class;
            System.out.println(clazz2);
//            3. 通过对象.getClass()获取
            TypeDemo01 typeDemo01 = new TypeDemo01();
            Class clazz3 = typeDemo01.getClass();
            System.out.println(clazz3);
            /**
             * 会发现这三种拿到的值，都是相等的。
             * 可以得出一个结论，在当前的jdk运行环境中，同一个.class字节码文件只被加载一次，
             * 被加载之后，第二次再去拿的话，就会直接引用之前的，所以是一样的。
             */
            System.out.println(clazz1 == clazz2);
            System.out.println(clazz2 == clazz3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
