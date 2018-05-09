//package com.cc.service.impl;
//
//import com.cc.exception.BusinessException;
//import org.csource.common.MyException;
//import org.csource.fastdfs.ClientGlobal;
//import org.csource.fastdfs.StorageClient;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;
//import org.springframework.core.io.ClassPathResource;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author qiancongcong
// * @create 2018-04-25 下午9:57
// * @desc
// **/
//public class UploadService {
//    //上传原图与缩略图
//    public Map<String,String> upload(byte[] ImageBytes, String prefix) {
//
//        TrackerServer server = getTrackerServer();
//        StorageClient client = new StorageClient(server,null);
//
//        try {
//
//            String []  original = client.upload_file(ImageBytes, prefix, null);
//
//            if(original == null){
//                throw new BusinessException("上传图片失败");
//            }else{
//                //"http://"+server.getInetSocketAddress().getHostName()+"/"+ original[0]+ "/"+original[1];
//                String originalUrl = original[0] + "/"+original[1];
//
//
//                Map<String,String> urls = new HashMap<>();
//                urls.put("original", originalUrl);
//                return urls;
//            }
//
//        } catch (IOException | MyException e) {
//            throw new BusinessException(e.getMessage());
//        }
//
//    }
//
//    private TrackerServer getTrackerServer(){
//
//        try {
//            ClientGlobal.init((new ClassPathResource("fdfs_client.conf")).getFile().getAbsolutePath());
//            TrackerClient tracker = new TrackerClient();
//            return tracker.getConnection();
//        } catch (IOException | MyException e) {
//            throw new BusinessException("ss");
//        }
//    }
//}
