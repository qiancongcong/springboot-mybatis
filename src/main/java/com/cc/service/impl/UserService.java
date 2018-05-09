package com.cc.service.impl;

import com.cc.exception.BusinessException;
import com.cc.mapper.UserMapper;
import com.cc.pojo.User;
import com.cc.pojo.UserQuery;
import com.sun.javafx.iio.ImageStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: cc
 * @Date: Created in 10:05 2018/1/2
 */
@Service
public class UserService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public List<User> querUser(UserQuery userQuery){
        return userMapper.querUser(userQuery);
    }


}
