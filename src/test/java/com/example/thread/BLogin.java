package com.example.thread;

/**
 * @ClassName ALogin
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-28 11:05
 * @Version v.1.0.0
 */
public class BLogin extends Thread {
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        super.run();
        LoginSevlet.doPost("b","bb");
    }
}
