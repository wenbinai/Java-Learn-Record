//package com.aiwenbin.exam.Exam04;
//
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class TakeMoney implements Runnable {
//    private static int  money = 10000;
//    @Override
//    public void run() {
//        Lock lock = new ReentrantLock();
////        synchronized (this) {
//            while (true) {
//                if ("A".equals(Thread.currentThread().getName())) {
//                    lock.lock();
//                    money = money - 300;
//                    lock.unlock();
//                    if(money < 0) {
//                        System.out.println("余额不足。");
//                        break;
//                    }else {
//                        System.out.println("A在柜台进行取钱，取了300元！目前账户还有" + money +  "元");
//                    }
////                    try {
////                        Thread.sleep(5000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
//                }
//                if ("B".equals(Thread.currentThread().getName())) {
//                    lock.lock();
//                    money = money - 200;
//                    lock.unlock();
//                    if(money < 0) {
//                        System.out.println("余额不足。");
//                        break;
//                    } else {
//                        System.out.println("B在柜台进行取钱，取了200元！目前账户还有" + money +  "元");
//                    }
//                   try {
//                      Thread.sleep(5000); } catch (InterruptedException e) {
//                       e.printStackTrace(); }
//                }
//            }
////        }
//
//    }
////}
