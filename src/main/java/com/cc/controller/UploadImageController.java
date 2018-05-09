//package com.cc.controller;
//
//import com.cc.service.impl.UploadService;
//import com.cc.util.ResponseJson;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * @author qiancongcong
// * @create 2018-04-25 下午10:03
// * @desc
// **/
//public class UploadImageController {
//    @Autowired
//    private UploadService uploadService;
//    @RequestMapping(value = "file", method = RequestMethod.POST)
//    @ApiOperation(value = "上传文件并保存到数据库")
//    @ResponseBody
//    public ResponseJson fileUpload(
//            @ApiParam(value = "文件",required = true)
//            @RequestParam MultipartFile image) throws IOException {
//
//        String prefix=getPrefix(image);//获得文件后缀
//
//
//        String fileName = image.getOriginalFilename();
//
//        Map<String, String> upload = uploadService.upload(image.getBytes(), prefix);
//        return ResponseJson.ok(upload);
//
//    }
//
//    //获得文件后缀
//    private String getPrefix(MultipartFile file){
//        String fileName = file.getOriginalFilename();
//        return fileName.substring(fileName.lastIndexOf(".")+1);
//    }
//}
