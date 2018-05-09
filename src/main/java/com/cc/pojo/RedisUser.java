package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.Serializable;

/**
 * @Author: cc
 * @Date: Created in 17:05 2018/1/4
 */
@Data
@Log4j
@NoArgsConstructor
@AllArgsConstructor
public class RedisUser implements Serializable  {

    private static final long serialVersionUId = 1l;

    private String id;
    private String name;


}
