package com.aiwenbin.exam.Exam01;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

    }
    public static String getAppleBrandName(Apple apple) {
        return Optional.ofNullable(apple)
                .map(Apple::getKind)
                .map(Kind::getBrand)
                .map(Brand::getBrandName)
                .orElse("品牌信息不存在");
    }
}
