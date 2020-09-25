package com.aiwenbin.proxy.demo01;

public class ProxyTest01 {
    public static void main(String[] args) {
        IService serviceA = new ServiceProxy(new ServiceA());
        IService serviceB = new ServiceProxy(new ServiceB());
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();

        serviceB.m1();
        serviceB.m2();
        serviceB.m3();
    }
}
