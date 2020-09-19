package com.example.springdemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class RedisTest {

    public static void main(String[] args) throws Exception {
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();
//        Jedis jedis2 = jedisPool.getResource();
//        Jedis jedis3 = jedisPool.getResource();
//        Jedis jedis4 = jedisPool.getResource();
        System.out.println(jedis.ping());
        System.out.println("当前有" + jedisPool.getNumActive() + "个Jedis连接");
        Set<String> keys = jedis.keys("*");
        System.out.println("当前存在：" + keys.size() + " 个键");
//        keys.forEach(System.out::println);
//        jedis.sadd("lang","java","jsp","net","php","redis","mysql","mysql");
//        jedis.sadd("lang2", Arrays.asList("1","2").stream().collect(Collectors.joining(",")));
//        jedis.smembers("lang").forEach(System.out::println);
//        String sr = jedis.mset("m1","m11","m2","m22");
//        System.out.println(sr);
//        Map<String,String> map = jedis.hgetAll("h1");
//        map.forEach((k,v)-> System.out.println(k+"--"+v));

//        List<String> list = jedis.blpop(10,"list1");
//        list.forEach(System.out::println);
//        Set<Tuple> set =jedis.zrevrangeWithScores("z11",0,-1);
//        set.forEach(e-> System.out.println(e.getElement()+"--"+e.getScore()));
        int resource = 20;
//        ExecutorService executorService = Executors.newFixedThreadPool(20);
//        try {
//            for (int i = 0; i < 20; i++) {
//                System.out.println(jedisPool.getNumActive());
//                executorService.execute(new Order(jedis,resource));
//            }
//        }catch (Exception e){
//
//        }finally {
//            executorService.shutdown();
//        }
        long startTime = System.currentTimeMillis();
        Random random = new Random(10000);
        while (jedis.scard("testOrders") < 1000) {
            String clientName = Thread.currentThread().getName();
            long result = resource > 0 ? (jedis.sadd("testOrders", clientName + "-"+random.nextInt(10000))) : 0;
            if (result > 0)
                resource--;
            System.out.println(clientName + (result > 0 ? "抢购成功" : "因抢购结束而宣告失败"));
        }
        long stopTime = System.currentTimeMillis();
        System.out.println((stopTime - startTime) / 1000 + "秒内填充完成");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.keySet();

    }
}

class Order implements Runnable {

    private Jedis jedis;

    private int resource;

    public Order(Jedis jedis, int resource) {
        this.jedis = jedis;
        this.resource = resource;
    }

    @Override
    public void run() {
        String clientName = Thread.currentThread().getName();
        long result = resource > 0 ? (jedis.sadd("testOrders", clientName + "-")) : 0;
        System.out.println(clientName + (result > 0 ? "抢购成功" : "因抢购结束而宣告失败"));
    }
}

