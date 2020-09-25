//package com.aiwenbin.exam.Exam04;
//
//public class Main {
//    public static void main(String[] args) {
//        TakeMoney takeMoney = new TakeMoney();
//        Thread threadA = new Thread(takeMoney, "A");
//        Thread threadB = new Thread(takeMoney, "B");
//
//        threadB.start();
////        try {
////            threadB.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        try {
//            threadB.wait(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        threadA.start();
//
//
//    }
//}
