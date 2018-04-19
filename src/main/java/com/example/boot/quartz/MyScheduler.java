package com.example.boot.quartz;

import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyScheduler
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-19 16:58
 * @Version v.1.0.0
 */
@Component
public class MyScheduler {

    public void schedulerJob() throws SchedulerException {
        ApplicationContext annotationContext = SpringUtil.getApplicationContext();
        Scheduler myScheduler = (StdScheduler) annotationContext.getBean("mySchedulerFactoryBean");
        startScheduler1(myScheduler);
        startScheduler2(myScheduler);
        myScheduler.start();
    }

    private void startScheduler1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MySchedulerJob.class).withIdentity("job1", "jobGroup1").build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("5 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private void startScheduler2(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MySchedulerJob2.class).withIdentity("job2", "jobGroup2").build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("5 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "triggerGroup2")
                .withSchedule(cronScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);

    }
}
