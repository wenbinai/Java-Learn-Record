package com.aiwenbin.mulit_status_example;

public class S extends F {
    public void getS() {
        System.out.println("S get S");
    }

    @Override
    public void getF() {
        System.out.println("S get F");
    }

    @Override
    public void getI() {
        System.out.println("S get I");
    }

    public static void main(String[] args) {
//        F f = new F();
//        S s = (S) f;
//        s.getF();
//        S s = new S();
//        F f =  s;
//        f.getI();
//        S s = new F();
//        s.getF();
        I i = new S();
        F f = (F) i;
        S s = (S) f;
        s.getI();
    }
}
