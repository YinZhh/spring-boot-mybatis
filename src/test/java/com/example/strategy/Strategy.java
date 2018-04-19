package com.example.strategy;

/**
 * @ClassName Strategy
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-26 11:14
 * @Version v.1.0.0
 */
public class Strategy {

    public static void strategic(Shape s) {
        s.outputShape();
    }

    public static void main(String[] args) {

        strategic(new Circle());
        strategic(new Square());
        strategic(new Triangle());
    }
}
