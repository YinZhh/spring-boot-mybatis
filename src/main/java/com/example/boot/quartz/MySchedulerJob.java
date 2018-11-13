package com.example.boot.quartz;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName MySchedulerJob
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-19 16:54
 * @Version v.1.0.0
 */
@Component
public class MySchedulerJob implements Job {

    private SimpleDateFormat dateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    public void execute(JobExecutionContext context) {
        System.out.println("AAAA: The time is now " + dateFormat().format(new Date()));
    }
}
