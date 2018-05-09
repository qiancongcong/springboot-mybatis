package com.cc.util;

import java.io.Serializable;

/**
 *  返回格式
 * @param <T>
 */

public class ResponseJson<T> implements Serializable {

    private static final long serialVersionUID = -2825436079063723409L;

    private static final String OK = "200";
    private static final String FAILED = "500";
    private static final String BUSSINESS_FAILED = "550";
    private static final String UNAUTHENTICATION = "501"; //未登录

    private String retCode;
    private String message;
    private T data;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private static <T> ResponseJson<T> buildResponse(String retCode,String message,T data){
        ResponseJson<T> responseJson = new ResponseJson<>();
        responseJson.retCode = retCode;
        responseJson.message = message;
        responseJson.data = data;
        return responseJson;
    }

    public static <T> ResponseJson<T> ok(){
        return buildResponse(ResponseJson.OK,"成功。",null);
    }
    public static <T> ResponseJson<T> ok(T data){
        return buildResponse(ResponseJson.OK,"成功。",data);

    }
    public static <T> ResponseJson<T> ok(String message,T data){
        return buildResponse(ResponseJson.OK,message,data);
    }


    public static <T> ResponseJson<T> failed(String message){
        return buildResponse(ResponseJson.FAILED,message,null);
    }

    public static <T> ResponseJson<T> failed(String message,T data){
        return buildResponse(ResponseJson.FAILED,message,data);
    }

    public static <T> ResponseJson<T> businessFailed(String message){
        return buildResponse(ResponseJson.BUSSINESS_FAILED,message,null);
    }

    public static <T> ResponseJson<T> unauthentication(String message){
        return buildResponse(ResponseJson.UNAUTHENTICATION,message,null);
    }

}

