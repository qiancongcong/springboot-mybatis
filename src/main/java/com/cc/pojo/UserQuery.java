package com.cc.pojo;

import com.cc.base.AbstractQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.solr.client.solrj.beans.Field;

/**
 * @Author: cc
 * @Date: Created in 9:55 2018/1/2
 */
@Data//提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@Log4j //为类提供一个 属性名为log 的 log4j 日志对象
@NoArgsConstructor///为类提供一个无参的构造方法
@AllArgsConstructor//为类提供一个全参的构造方法

public class UserQuery extends AbstractQuery{

    //手机号
    @Field("phone")
    private String phone;
    //登录账号
    @Field("loginName")
    private String loginName;
    //邮箱
    private String email;
    //密码
    private String password;
    //盐（密码加密时和密码混合使用）
    private String salt;
    //昵称
    private String nickName;
    //性别（0男、1女、2保密）
    private String sex;
    //生日
    private String birthday;
    //地址
    private String address;
    //'省
    private String provinceCode;
    //市
    private String cityCode;
    //区
    private String countyCode;


}
