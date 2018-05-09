//package com.cc.controller;
//
//import com.cc.pojo.User;
//import com.cc.pojo.UserQuery;
//import com.cc.util.ResponseJson;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import jdk.nashorn.internal.runtime.options.Option;
//import lombok.extern.log4j.Log4j;
//import org.apache.zookeeper.Op;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
///**
// * @Author: cc
// * @Date: Created in 15:29 2018/1/25
// */
//@Api(description = "用户登陆注册")
//@RequestMapping("/loginAndRegisterUser")
//@RestController
//@Log4j
//public class LoginAndRegisterUserController {
//
//
//    @RequestMapping(method = RequestMethod.POST)
//    @ApiOperation(value = "注册")
//    public ResponseJson<User> createUser(
//            @ApiParam(value = "手机号",required = true)
//            @RequestParam Optional<String> phone,
//            @ApiParam(value = "密码",required = true)
//            @RequestParam Optional<String> password){
//        log.info("注册");
//        UserQuery userQuery = new UserQuery();
//        phone.ifPresent(userQuery::setPhone);
//        password.ifPresent(userQuery::setPassword);
//
//        return ResponseJson.ok();
//
//    }
//
//}
