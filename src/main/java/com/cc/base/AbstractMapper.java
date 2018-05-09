package com.cc.base;

import java.util.List;

/**
 * myBatis Mapper的基类
 */
public interface AbstractMapper<T extends AbstractEntity,Q extends AbstractQuery> {

    List<T> selectByExample(Q example);

    T selectUniqueByExample(Q example);

    T selectByPrimaryKey(Long id);

    Integer countByExample(Q example);

    Integer deleteByPrimaryKey(T entity);

    Long insert(T entry);

    Integer updateByPrimaryKey(T entity);

    Integer deleteWithLockByPrimaryKey(T entity);

    Integer updateWithLockByPrimaryKey(T entity);

}
