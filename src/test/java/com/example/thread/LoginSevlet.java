package com.example.thread;

/**
 * @ClassName LoginSevlet Annotate method 'arraycopy' as @Deprecated
 * @Description That's the purpose of the class 图标
 * @Author yin.zhh
 * @Date 2018-03-28 10:59
 * @Version v.1.0.0
 */
public class LoginSevlet {
    private static String userName;
    private static String passWord;

    @Deprecated
    public synchronized static void doPost(String name, String pass) {
        try {
            userName = name;
            if ("a".equals(name)) {
                Thread.sleep(1000);
            }
            passWord = pass;

            System.out.println("username=" + userName + "  password=" + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
