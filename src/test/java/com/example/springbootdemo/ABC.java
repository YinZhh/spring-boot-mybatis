package com.example.springbootdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ABC
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-02-28 13:33
 * @Version v.1.0.0
 */
public class ABC {
    private static ReentrantLock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    private static int flag = 1;

    public static void main(String[] args) {

        new TXA().start();

        new TXB().start();

        new TXC().start();
    }

    static class TXA extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                lock.lock();
                try {
                    while (flag != 1) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + "a");
                    flag = 2;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class TXB extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                lock.lock();
                try {
                    while (flag != 2) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + "b");
                    flag = 3;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class TXC extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                lock.lock();
                try {
                    while (flag != 3) {
                        conditionC.await();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + "c");
                    System.out.println();
                    flag = 1;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
