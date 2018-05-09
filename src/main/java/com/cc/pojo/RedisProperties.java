package com.cc.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: cc
 * @Date: Created in 15:15 2018/2/5
 */
@Component
@ConfigurationProperties(prefix = "redis.cache")
@Data
public class RedisProperties {

    private int    expireSeconds;
    private String clusterNodes;
    private int    commandTimeout;
}
