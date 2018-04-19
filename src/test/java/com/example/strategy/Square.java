package com.example.strategy;

/**
 * @ClassName Square
 * @Description That's the purpose of the class 策略2
 * @Author yin.zhh
 * @Date 2018-03-26 11:11
 * @Version v.1.0.0
 */
public class Square implements Shape {
    @Override
    public void outputShape() {
        System.out.println("This is a Square");
    }
}
