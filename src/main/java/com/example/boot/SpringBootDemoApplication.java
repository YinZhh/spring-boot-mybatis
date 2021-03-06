package com.example.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 *
 * @Description That's the purpose of the class capture memory snapshot Jakarta
 * @Author yin.zhh
 * @Date 2018/2/22 16:45
 * @Version v.1.0.0
 */
@SpringBootApplication
public class SpringBootDemoApplication {

    /**
     * @Description (That's the purpose of the method)
     * @Date 2018/2/22 16:46
     * @Param args
     * @Return void
     * @Throws
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootDemoApplication.class).web(true).run(args);
        //SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
