//package com.cc.controller;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.JedisCluster;
//
///**
// * @Author: cc
// * @Date: Created in 10:23 2018/2/2
// */
//
//@RestController
//@RequestMapping("/redisCluster")
//@Api(description = "redisCluster")
//@Slf4j
//public class RedisClusterController {
//
//    @Autowired
//    private JedisCluster jedisCluster ;
//
//
//    /**
//     * 测试redis集群
//     * @return
//     */
//    @RequestMapping(value = "redisCluster",method = RequestMethod.GET)
//    @ApiOperation(value = "保存并查找一个值")
//    public void queryRedisCluster() {
//        String key = "redisTestKey";
//        String value = "cc";
//
//        jedisCluster.set(key,value);
//        //数据插入测试：
//        String valueFromRedis = jedisCluster.get(key);
//        log.info("redis value after set: {}"+valueFromRedis);
//    }
//
//
//}
