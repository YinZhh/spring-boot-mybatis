package com.example.boot.quartz;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName MySchedulerListener
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-19 16:44
 * @Version v.1.0.0
 */
@Component
public class MySchedulerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MyScheduler myScheduler;

    @Autowired
    private MyJobFactory myJobFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            myScheduler.schedulerJob();
            System.out.println("SynchronizedData job  start...niacinamide");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Bean(name ="mySchedulerFactoryBean")
    public SchedulerFactoryBean mySchedulerFactory() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setOverwriteExistingJobs(true);
        bean.setStartupDelay(1);
        bean.setJobFactory(myJobFactory);
        return bean;
    }
}
