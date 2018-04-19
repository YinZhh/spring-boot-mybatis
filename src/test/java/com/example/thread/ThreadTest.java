package com.example.thread;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Test;

/**
 * @ClassName ThreadTest
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-28 10:17
 * @Version v.1.0.0
 */
public class ThreadTest {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        MyThread myThread1 = new MyThread("A");
//        MyThread myThread2 = new MyThread("B");
//        MyThread myThread3 = new MyThread("C");
//        MyThread myThread4 = new MyThread("D");

//        myThread1.start();
//        myThread2.start();
//        myThread3.start();
//        myThread4.start();
//        int aplusb = aplusb(7, 5);
//        System.out.println(aplusb);
//        MyThread thread = new MyThread("主");
//        Thread threa1 = new Thread(thread,"1");
//        Thread threa2 = new Thread(thread,"2");
//        Thread threa3 = new Thread(thread,"3");
//        Thread threa4 = new Thread(thread,"4");
//        Thread threa5 = new Thread(thread,"5");
//        threa1.start();
//        threa2.start();
//        threa3.start();
//        threa4.start();
//        threa5.start();

//        ALogin aLogin = new ALogin();
//        aLogin.start();
//
//        aLogin.suspend();
//        aLogin.resume();
//
//        BLogin bLogin = new BLogin();
//        bLogin.start();


        //boolean interrupted = Thread.interrupted();
        //aLogin.interrupt();
        //boolean interrupted1 = aLogin.isInterrupted();

        //bLogin.stop();
        //System.out.println(interrupted);
        //System.out.println(interrupted1);
        int num = 5;

        //int a = 15;
        //int b = 10;

        //int a = 12;//1100
        //int b = 4;
        int a = 8;//1100
        int b = 4;

        int c = a & b;
        int d = a ^ b;

        System.out.println(c + "   -----   " + d);


        convertToBinary(num);
        StringBuilder reverse = sb.reverse();
        if ((num & 1) == 0) {
            //奇数
            reverse.append(0);
        } else {
            reverse.append(1);
        }
        System.out.println(reverse);

        System.out.println(aplusb(15, 10));
    }

    /**
     * 65.5 + 8 = 73.5 ----- 总计 2017加班 + 2018年加班
     * 4 * 8 = 32  -----过年请假4天
     * 73.5 - 32 - 5 = 36.5  -----元宵节放假半天
     * 3 * 8 = 24  -----清明请假三天
     * 36.5 - 24 = 12.5  ----- 还剩12.5天
     *
     * @Description (That ' s the purpose of the method) 36.5
     * // 主要利用异或运算来完成
     * // 异或运算有一个别名叫做：不进位加法
     * // 那么a ^ b就是a和b相加之后，该进位的地方不进位的结果
     * // 然后下面考虑哪些地方要进位，自然是a和b里都是1的地方
     * // a & b就是a和b里都是1的那些位置，a & b << 1 就是进位
     * // 之后的结果。所以：a + b = (a ^ b) + (a & b << 1)
     * // 令a' = a ^ b, b' = (a & b) << 1
     * // 可以知道，这个过程是在模拟加法的运算过程，进位不可能
     * // 一直持续，所以b最终会变为0。因此重复做上述操作就可以
     * // 求得a + b的值。
     * @Date 2018/4/9 14:28
     * @Param [a, b]
     * @Return int
     * @Throws
     */
    private static int aplusb(int a, int b) {

        if (b == 0) return a;

        return aplusb(a ^ b, (a & b) << 1);

    }

    /**
     * @Description (That ' s the purpose of the method)
     * @Date 2018/4/8 11:34
     * @Param []
     * @Return void
     * @Throws 4 % 2
     */
    public static void convertToBinary(int num) {

        int a = num / 2;
        if (a < 2) {
            sb.append(a);
        } else {
            int b = a % 2;
            sb.append(b);
            convertToBinary(a);
        }

    }

    @Test
    public void demo() {//5555550000000L
        //long zeros = trailingZeros(5555550000000L);//1613063388   1388887499996
        //System.out.println(zeros);
        //int a = Pos_Div(11, 3);

        //System.out.println(a);
        int a = 34234324;


        int k = 2;
        int count = 0;
        while (a > 0) {
            if (a % 10 == k) {
                count++;
            }
            a /= 10;
        }
        System.out.println(count);

        int digitCounts = digitCounts(2, 12);
        System.out.println(digitCounts);
    }


    private long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long num = 0;
        while (n > 0) {
            num += (n / 5);
            n /= 5;
        }
        return num;
    }

    /**
     * 34234324
     *
     * @Description (That ' s the purpose of the method)
     * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
     * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
     * @Date 2018/4/10 11:20
     * @Param [k, n]
     * @Return int
     * @Throws
     */
    private int digitCounts(int k, int n) {
        // write your code here
        int i, j, num = 0;
        if (k == 0)
            num = 1;
        for (i = 0; i <= n; i++) {
            j = i;
            while (j != 0) {
                if (j % 10 == k)
                    num++;
                j = j / 10;
            }
        }
        return num;

    }

    int Pos_Div(long x, int y) {

        int ans = 0;

        for (int i = 31; i >= 0; i--) {

            //比较x是否大于y的(1<<i)次方，避免将x与(y<<i)比较，因为不确定y的(1<<i)次方是否溢出

            if ((x >> i) >= y) {

                ans += (1 << i);

                x -= (y << i);

            }

        }
        return ans;

    }
}