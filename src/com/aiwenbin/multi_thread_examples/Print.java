package com.aiwenbin.multi_thread_examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print {
    public static void main(String[] args) {

    }
}

class PrintRunnable implements Runnable {
    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        lock.unlock();
    }
}
