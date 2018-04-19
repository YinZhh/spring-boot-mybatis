package com.example.boot.quartz;

import com.example.boot.domain.IInventory;
import com.example.boot.service.InventoryService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName MySchedulerJob2
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-03-19 16:55
 * @Version v.1.0.0
 */

@Component
public class MySchedulerJob2 implements Job {

    /** 这个service为spring管理的对象，service可自由编写 */
    @Autowired
    private InventoryService InventoryService;

    /**
     * 使用StringRedisTemplate进行操作.直接注入即可(只需引入jar包,配置application.properties)
     *
     * StringRedisTemplate对redis操作进行了很好的封装，为键、字符串、哈希、列表、集合、有序集合、HyperLogLog的操作提供了良好的支持。
     * 基本使用形式就是redisTemplate.opsForXXX,XXX是类型
     * opsForValue是操作字符串;
     * opsForSet是操作集合;
     * opsForList是操作列表;
     * opsForZSet是操作有序集合;
     * opsForHyperLogLog是操作HyperLogLog;
     * 基本上其方法和redis命令是对应的，可以根据名字和方法注释快速确定方法对应的redis命令。
    */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 使用RedisTemplate(需引入jar包,创建RedisObjectSerializer.java,RedisConfiguration.java类,配置application.properties)
     */
    @Autowired
    private RedisTemplate<String, Object> objRedisTemplate;

    @Override
    public void execute(JobExecutionContext context) {
        IInventory iInventory = InventoryService.selectPrimaryKey("2E5CB85354344F6B9B8BCAA3DF3818C8");

        //使用StringRedisTemplate
        String name = stringRedisTemplate.opsForValue().get("name");

        //使用RedisTemplate
        objRedisTemplate.opsForValue().set("iInventory", iInventory,50,TimeUnit.SECONDS);
        iInventory = (IInventory) objRedisTemplate.opsForValue().get("iInventory");
        System.out.println(name + "   SchedulerJob2 event number: " + iInventory);
    }
}