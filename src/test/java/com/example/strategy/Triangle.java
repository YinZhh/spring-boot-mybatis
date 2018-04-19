package com.example.strategy;

/**
 * @ClassName Triangle
 * @Description That's the purpose of the class 策略3
 * @Author yin.zhh
 * @Date 2018-03-26 11:12
 * @Version v.1.0.0
 */
public class Triangle implements Shape {
    @Override
    public void outputShape() {
        System.out.println("This is a Triangle");
    }
}
