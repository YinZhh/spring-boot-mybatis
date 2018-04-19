package com.example;

import com.alibaba.druid.sql.visitor.functions.If;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * @ClassName Test
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-04-12 15:59
 * @Version v.1.0.0
 */
public class Test {

    //Redis服务器IP
    private static String ADDR = "47.106.137.210";
    //阿里云redis提供的 实例ID:密码
    private static String passwd = "123456";

    //Redis的端口号
    private static int PORT = 6379;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;

    private static int TIMEOUT = 10000;


    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
//    static {
//        try {
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(MAX_ACTIVE);
//            config.setMaxIdle(MAX_IDLE);
//            config.setMaxWaitMillis(MAX_WAIT);
//            config.setTestOnBorrow(TEST_ON_BORROW);
//            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, passwd);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public static void main(String[] args) {
//        Test t = new Test();
//        t.first();
//
//        int[] arr = {1,2,3,4,5};
//
//        change(arr);
//
//        System.out.println(arr[0]);


        Jedis jedis = new Jedis("47.106.137.210",6379);


        //Set<String> keys = jedis.keys("*");

        System.out.println(jedis.get("name"));
//        Jedis client = Test.getJedis();
//        System.out.println(client);

    }

    private void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        seccound(v, i);
        System.out.println(v.i + "&" + i + "\r\n");

    }

    private void seccound(Value v, int i) {
        i = 0;
        v.i = 20;
        v = new Value();

        System.out.println(v.i + "&" + i + "\r\n");
        //15&0
        //25&5
    }

    //将数组的第一个元素变为0
    private static void change(int[] array) {
        array[0] = 110;

        array = new int[]{11, 22, 33, 44, 55};
    }

    /**
     * 获取Jedis实例
     *
     * @Return Jedis
     */
    private synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     *
     * @Param jedis
     */
    public static void releaseResource(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
