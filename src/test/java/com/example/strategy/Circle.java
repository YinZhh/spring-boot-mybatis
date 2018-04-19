package com.example.strategy;

/**
 * @ClassName Circle
 * @Description That's the purpose of the class 策略1
 * @Author yin.zhh
 * @Date 2018-03-26 11:09
 * @Version v.1.0.0
 */
public class Circle implements Shape {

    @Override
    public void outputShape() {
        System.out.println("This is a Circle");
    }
}
