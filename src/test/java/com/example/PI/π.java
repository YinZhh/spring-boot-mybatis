package com.example.PI;

import java.util.Scanner;

/**
 * @ClassName π 3.14159265358979323846
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-04-26 16:09
 * @Version v.1.0.0
 */
public class π {
    public static void main(String[] arg) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        double sum = 1;
        int flag = -1;
        for (int i = 1; i < n; i++) {
            //sum += (1.0 / (4 * i + 1)) - (1.0 / (4 * i - 1)); 这段代码可以修改为如下代码
            sum += flag * (1.0 / (2 * i + 1));
            flag *= -1; //flag 会 1，-1，1，-1 ...循环
            System.out.println(flag); //跟踪flag的值
            System.out.println(4 * sum);//跟踪 PI 的值
        }
        sum *= 4;
        System.out.println(sum); //最终的输出
        System.out.println(Math.PI); //Math是一个工具类，里面封装了很多常用的数学方法
        //PI代表圆周率的估值,Math.PI=3.141592653589793
    }
}

