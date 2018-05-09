//package com.cc.controller;
//
//import com.cc.pojo.User;
//import com.cc.pojo.UserQuery;
//import com.cc.service.impl.UserService;
//import com.cc.util.ResponseJson;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
///**
// * @Author: cc
// * @Date: Created in 10:07 2018/1/2
// */
//@RestController
//@RequestMapping("/uers")
//@Api(description = "用户")
//@Slf4j
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    RedisTemplate redisTemplate;
//
//    @ApiOperation(value = "查询用户从信息" )
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseJson<List<User>> querUser(){
//        log.info("开始");
//        List<User> users =null;
//        ValueOperations<String,List<User>> operations = redisTemplate.opsForValue();
//        Boolean user = redisTemplate.hasKey("user");
//        if(!user){
//            UserQuery userQuery = new UserQuery();
//            users = userService.querUser(userQuery);
//            //LocalDateTime midnight = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0).withSecond(0).withNano(0);
//            //long seconds = ChronoUnit.SECONDS.between(LocalDateTime.now(), midnight);
//            //operations.set("user", users, 10, TimeUnit.SECONDS);
//            operations.set("user",users);
//            log.info("设置缓存");
//        }else{
//            users = operations.get("user");
//        }
//
//        return ResponseJson.ok(users);
//    }
//
//}
