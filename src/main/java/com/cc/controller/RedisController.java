package com.cc.controller;

import com.cc.pojo.User;
import com.cc.service.impl.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: cc
 * @Date: Created in 17:11 2018/1/4
 */
@RestController
@RequestMapping("/redis")
@Api(description = "redis")
@Slf4j
public class RedisController {

    @Autowired
    RedisService redisService;

    /**
     * 设置Str缓存
     * @param key
     * @param
     * @return
     */
    @RequestMapping(value = "setStr",method = RequestMethod.POST)
    @ApiOperation(value = "保存一个key vlaue")
    public String setStr(
                    @ApiParam(value = "key",required =  true)
                    @RequestParam String key,
                    @ApiParam(value = "value",required = true)
                    @RequestParam String val){
        try {
            redisService.setStr(key, val);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 根据key查询Str缓存
     * @param
     * @return
     */
    @RequestMapping(value = "getStr",method = RequestMethod.GET)
    @ApiOperation(value = "根据key取value  String类型")
    public String getStr(
                @ApiParam(value = "key",required = true)
                @RequestParam String key){
        return redisService.getStr(key);
    }


    /**
     * 根据key产出Str缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "delStr",method = RequestMethod.GET)
    @ApiOperation(value = "根据key 删除")
    public String delStr(
            @ApiParam(value = "key",required = true)
            @RequestParam String key){
        try {
            redisService.del(key);
            return "success";
        } catch (Exception e){
            return "error";
        }
    }


    /**
     * 设置obj缓存
     * @param key
     * @param user
     * @return
     */
    @RequestMapping(value = "setObj",method = RequestMethod.POST)
    @ApiOperation(value = "保存一个key value为一个对象 序列号为JDK")
    public String setObj(
                @ApiParam(value = "key",required = true)
                @RequestParam String key,
                @ApiParam(value = "User", required = true)
                @RequestBody User user){
        try {
            redisService.setObj(key, user);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 获取obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "getObj",method = RequestMethod.GET)
    @ApiOperation(value = "根据key 取一个对象")
    public Object getObj(
            @ApiParam(value = "key", required = true)
            @RequestParam String key){
        return redisService.getObj(key);
    }


    /**
     * 删除obj缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "delObj",method = RequestMethod.POST)
    @ApiOperation(value = "根据一个key删除")
    public Object delObj(
            @ApiParam(value = "key",required = true)
            @RequestParam String key){
        try {
            redisService.delObj(key);
            return "success";
        } catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

}
