package com.example.springbootdemo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName TestDemo
 * @Description That's the purpose of the class
 * 假如有Thread1、Thread2、Thread3、Thread4四条线程分别统计C、D、E、F四个盘的大小，
 * 所有线程都统计完毕交给Thread5线程去做汇总，应当如何实现？
 * @Author yin.zhh
 * @Date 2018-02-27 10:14
 * @Version v.1.0.0
 */
public class TestDemo {

    private static int D;
    private static int E;
    private static int F;
    private static int G;
    private static int H;

    public static void main(String[] args) throws InterruptedException {
        //Thread t1 = new Thread(() -> countFile(new File("D:\\Destintion")));
        //t1.start();
        //t1.join();

        /*Thread t2 = new Thread(() -> {
            countFile(new File("E:\\"));
        });
        t2.start();
        t2.join();

        Thread t3 = new Thread(() -> {
            countFile(new File("F:\\"));
        });
        t3.start();
        t3.join();

        Thread t4 = new Thread(() -> {
            countFile(new File("G:\\"));
        });
        t4.start();
        t4.join();

        Thread t5 = new Thread(() -> {
            countFile(new File("H:\\"));
        });
        t5.start();
        t5.join();*/

        //System.out.println("总计: " + (D + E + F + G + H));
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("F:\\tool\\Notepad++\\notepad++.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void countFile(File file) {
        synchronized (TestDemo.class) {
            File[] files = file.listFiles();
            assert files != null;
            for (File f : files) {
                if (f.isFile()) {
                    D += f.length();
                } else {
                    countFile(f);
                }
            }

            System.out.println(Thread.currentThread().getName() + "--" + D);
        }
    }

    @Test
    private void runtime() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("F:\\tool\\Notepad++\\notepad++.exe");
    }
}
