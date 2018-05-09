package com.cc.controller;

import com.cc.util.ResponseJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qiancongcong
 * @create 2018-04-25 下午8:53
 * @desc
 **/
@Api(description = "图片")
@RestController
@RequestMapping("/image")
public class RestImgController {

    @ApiOperation(value = "上传图片")
    @PostMapping(value = "/upload", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public ResponseJson uploadImg(
            @ApiParam(value = "图片",required = true) MultipartFile image) {
        String prefix=getPrefix(image);//获得文件后缀
        String fileName = image.getOriginalFilename();

       return ResponseJson.ok();

    }

    //获得文件后缀
    private String getPrefix(MultipartFile file){
        String fileName = file.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }
}
