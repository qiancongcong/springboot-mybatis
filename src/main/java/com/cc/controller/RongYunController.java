package com.cc.controller;

import com.cc.pojo.rongyun.*;
import com.cc.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

@RestController
@RequestMapping(value = "/rongyun")
@Api(description = "rongyun")
public class RongYunController {

    private static final String UTF8 = "UTF-8";
    private static final String PATH = "user";


    @ApiOperation(value = "查询用户从信息" )
    @RequestMapping(method = RequestMethod.POST)
    public ResponseJson querRongYunToken() throws Exception {
        UserModel userModel = new UserModel();
        userModel.setId("22");
        userModel.setName("cc");
        userModel.setPortrait("http://111.13.56.38:9999/static/user/d9d8ba36bc754a07a3bdac76e23f3099.jpeg");

        StringBuilder sb = new StringBuilder();
        sb.append("&userId=").append(URLEncoder.encode(userModel.id.toString(), UTF8));
        sb.append("&name=").append(URLEncoder.encode(userModel.name.toString(), UTF8));
        sb.append("&portraitUri=").append(URLEncoder.encode(userModel.portrait.toString(), UTF8));
        String body = sb.toString();
        if (body.indexOf("&") == 0) {
            body = body.substring(1, body.length());
        }
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnesctions("k51hidwqkc6vb", "7LHdD90AxziWQp", "/user/getToken.json", "application/x-www-form-urlencoded");
        HttpUtil.setBodyParameter(body, conn);

        Object o = GsonUtil.fromJson(CommonUtil.getResponseByCode(PATH, CheckMethod.REGISTER, HttpUtil.returnResult(conn)), TokenResult.class);
        System.out.println(o);
        return ResponseJson.ok(o);
    }



}
