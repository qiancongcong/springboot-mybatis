package com.cc.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * Created by Marvin on 2016/8/24.
 * 样本的基类
 */
@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractQuery implements Serializable {

    private static final long serialVersionUID = -52850483765351916L;
    @Field("id")  //如果不加此注解 solr将无法直接映射到对象里
    private Long id;
    private Integer pageNumber  = 1;
    private Integer rowStart = 0;
    private Integer pageSize = 10;
    private String userToken; // web层取得用户使用s

}
