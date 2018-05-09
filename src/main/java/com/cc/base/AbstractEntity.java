package com.cc.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import java.io.Serializable;
import java.util.Date;

@Data
@Log
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity implements Serializable {

    private Long id;
    private String creator;
    private Date createTime;
    private String updator;
    private Date modifyTime;
    private Boolean deleted;
    private String userToken; // web层取得用户使用

}
