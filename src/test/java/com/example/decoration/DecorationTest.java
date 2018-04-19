package com.example.decoration;

/**
 * @ClassName DecorationTest
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-26 10:24
 * @Version v.1.0.0
 */
public class DecorationTest {
    public static void main(String[] args) {
        BMWInterface bmwInterface = new BMW(new MercedesBenz());
        bmwInterface.fly();
    }
}
