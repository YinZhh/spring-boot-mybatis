package com.example.decoration;

/**
 * @ClassName BMW
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-26 10:21
 * @Version v.1.0.0
 */
public class BMW implements BMWInterface {

    private MercedesBenz mercedesBenz;

    public BMW(MercedesBenz mercedesBenz) {
        this.mercedesBenz = mercedesBenz;
    }

    @Override
    public void fly() {
        System.out.println("BMW-----------fly");
        pickUp();
        mercedesBenz.playMusic();
    }

    @Override
    public void pickUp() {
        System.out.println("BMW-----------pickUp");

    }
}
