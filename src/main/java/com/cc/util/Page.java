package com.cc.util;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Page<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer number;          //当前页码
    private Integer size;            //每页显示数量
    private Integer pageTotal;       //页数
    private Integer entityTotal;     //全部实体数
    private List<T> data;          //当页结果

    public Page() {
    }

    public Page(Integer number , Integer size) {
        this.size = size;
        this.number = number;
    }

    public Integer getSize() {
        return (size <=0 ? 1 : size);
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getEntityTotal() {
        return entityTotal;
    }

    public void setEntityTotal(Integer entityTotal) {
        this.entityTotal = (entityTotal == null ? 0 : entityTotal);
        this.entityTotal = (this.entityTotal < 0 ? 0 : this.entityTotal);
        pageTotal = (int) Math.ceil((double) this.entityTotal / (double) getSize());
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    // 返回当前页有多少条记录
    public int getCurSize() {
        if (number < 0) {
            return 0;
        }
        if (Objects.equals(number, pageTotal)) {
            int ret = pageTotal % getSize();
            return ret <= 0 ? getSize() : ret;
        } else {
            return getSize();
        }
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("Page:");
        buf.append("number=").append(number);
        buf.append(",size=").append(size);
        buf.append(",pageTotal=").append(pageTotal);
        buf.append(",entityTotal=").append(entityTotal);
        return buf.toString();
    }

}

