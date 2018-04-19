package com.example.springbootdemo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName CountDownLatchDemo
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-02-27 14:32
 * @Version v.1.0.0
 */
public class CountDownLatchDemo {

    private static long D;
    private static long E;
    private static long F;
    private static long G;
    private static long H;

    private static Map<String, Long> DP = new HashMap<>();
    private static Map<String, Long> EP = new HashMap<>();
    private static Map<String, Long> FP = new HashMap<>();
    private static Map<String, Long> GP = new HashMap<>();
    private static Map<String, Long> HP = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        //File file = new File("E:\\");
        //System.out.println(file.getPath().toCharArray()[0]);

//        File file = new File("E:\\$RECYCLE.BIN");
//        System.out.println(file.getName());


        CountDownLatch countDownLatch = new CountDownLatch(6);

        Thread D = new Thread(new CountFile(countDownLatch, new File("D:\\")), "D");
        Thread E = new Thread(new CountFile(countDownLatch, new File("E:\\")), "E");
        Thread F = new Thread(new CountFile(countDownLatch, new File("F:\\")), "F");
        Thread G = new Thread(new CountFile(countDownLatch, new File("G:\\")), "G");
        Thread H = new Thread(new CountFile(countDownLatch, new File("H:\\")), "H");

        D.start();
        E.start();
        F.start();
        G.start();
        H.start();

        countDownLatch.await();

        count();
    }

    private static void count() {
        System.out.println("总计: " + (D + E + F + G + H));
        System.out.println(DP);
        System.out.println(EP);
        System.out.println(FP);
        System.out.println(GP);
        System.out.println(HP);

        System.out.println((DP.get("D") + EP.get("E") + FP.get("F") + GP.get("G") + HP.get("H")));
    }

    static class CountFile implements Runnable {

        private CountDownLatch countDownLatch;

        private File FL;

        CountFile(CountDownLatch countDownLatch, File file) {
            this.countDownLatch = countDownLatch;
            this.FL = file;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            countFile(FL);
            countDownLatch.countDown();
        }

        private void countFile(File file) {
            File[] files = file.listFiles();
            if (files == null) {
                return;
            }
            for (File f : files) {
                if (f.isFile()) {
                    switch (Thread.currentThread().getName()) {
                        case "D":
                            D += f.length();
                            break;
                        case "E":
                            E += f.length();
                            break;
                        case "F":
                            F += f.length();
                            break;
                        case "G":
                            G += f.length();
                            break;
                        case "H":
                            H += f.length();
                            break;
                        default:
                            System.out.println("--------null---------" + Thread.currentThread().getName() + "==" + f.length());
                    }
                } else {
                    countFile(f);
                }
            }

            switch (Thread.currentThread().getName()) {
                case "D":
                    if (DP.get("D") == null) {
                        DP.put("D", D);
                    } else if (DP.get("D") < D) {
                        DP.put("D", D);
                    }
                    System.out.println(Thread.currentThread().getName() + "  ##########  " + D);
                    break;
                case "E":
                    if (EP.get("E") == null) {
                        EP.put("E", E);
                    } else if (EP.get("E") < E) {
                        EP.put("E", E);
                    }
                    System.out.println(Thread.currentThread().getName() + "  ##########  " + E);
                    break;
                case "F":
                    if (FP.get("F") == null) {
                        FP.put("F", F);
                    } else if (FP.get("F") < F) {
                        FP.put("F", F);
                    }
                    System.out.println(Thread.currentThread().getName() + "  ##########  " + F);
                    break;
                case "G":
                    if (GP.get("G") == null) {
                        GP.put("G", G);
                    } else if (GP.get("G") < G) {
                        GP.put("G", G);
                    }
                    System.out.println(Thread.currentThread().getName() + "  ##########  " + G);
                    break;
                case "H":
                    if (HP.get("H") == null) {
                        HP.put("H", H);
                    } else if (HP.get("H") < H) {
                        HP.put("H", H);
                    }
                    System.out.println(Thread.currentThread().getName() + "  ##########  " + H);
                    break;
                default:
                    System.out.println("--------null---------  " + Thread.currentThread().getName());
            }
        }
    }
}


