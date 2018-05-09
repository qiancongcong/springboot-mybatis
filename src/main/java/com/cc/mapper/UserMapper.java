package com.cc.mapper;

import com.cc.pojo.User;
import com.cc.pojo.UserQuery;

import java.util.List;

/**
 * @Author: cc
 * @Date: Created in 10:04 2018/1/2
 */
public interface UserMapper {

    List<User> querUser(UserQuery userQuery);
}
