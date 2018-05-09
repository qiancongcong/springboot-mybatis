package com.cc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.io.Serializable;

/**
 * @Author: cc
 * @Date: Created in 14:29 2018/1/17
 */
@Data
@Log
@NoArgsConstructor
@AllArgsConstructor
public abstract class PageQury implements Serializable {
    private static final long serialVersionUID = 1953592032762944983L;
    //总记录数
    private Integer recordCount;
    //总页数
    private Integer pageCount;
    //当前页
    private  Integer curPage;

}
