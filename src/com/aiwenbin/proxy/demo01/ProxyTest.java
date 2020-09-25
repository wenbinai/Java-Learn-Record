package com.aiwenbin.proxy.demo01;

import com.aiwenbin.mulit_status_example.S;

public class ProxyTest {
    public static void main(String[] args) {
        IService serviceA = new ServiceA();
        IService serviceB = new ServiceB();
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();

        serviceB.m1();
        serviceB.m2();
        serviceB.m3();
    }
}
