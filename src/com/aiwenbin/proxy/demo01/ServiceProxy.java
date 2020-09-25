package com.aiwenbin.proxy.demo01;

public class ServiceProxy implements IService {
    //    目标对象, 被代理的对象
    private IService target;

    public ServiceProxy(IService target) {
        this.target = target;
    }

    @Override
    public void m1() {
        long startTime = System.nanoTime();
        this.target.m1();
        long endTime = System.nanoTime();
        System.out.println(this.target.getClass() + "m1()方法耗时:" + (endTime - startTime));
    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }
}
