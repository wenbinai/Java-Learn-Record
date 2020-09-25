package com.aiwenbin.proxy.demo01;

public class ServiceA implements IService {
    @Override
    public void m1() {
        System.out.println("我是ServiceA中m1方法");
    }

    @Override
    public void m2() {
        System.out.println("我是ServiceA中m2方法");

    }

    @Override
    public void m3() {
        System.out.println("我是ServiceA中m3方法");

    }
}
