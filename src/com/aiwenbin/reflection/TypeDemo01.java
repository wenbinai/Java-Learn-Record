package com.aiwenbin.reflection;

import java.lang.reflect.Type;

public class TypeDemo01 implements Type {

    public String name;
    private String sex;

    public static void main(String[] args) {
        System.out.println(new TypeDemo01().getTypeName());
    }
}
