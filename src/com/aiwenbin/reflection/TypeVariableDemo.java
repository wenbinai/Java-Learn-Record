package com.aiwenbin.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 泛型的类型变量, 指的是List<T>
 *     中的T值
 */
public class  TypeVariableDemo<T> {
    private List<T> list;

    public TypeVariableDemo(List<T> list) {
        this.list = list;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Field fieldList = TypeVariableDemo.class.getDeclaredField("list");

        Type typeList = fieldList.getGenericType();
        ParameterizedType parameterizedTypeList = (ParameterizedType) typeList;
        Type[] type = parameterizedTypeList.getActualTypeArguments();
        System.out.println(type[0].getClass().getName());
    }
}
