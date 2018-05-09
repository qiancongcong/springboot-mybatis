package com.cc.base;
import com.cc.exception.BusinessException;
import com.cc.exception.keeper.NotFoundModifyTimeException;
import com.cc.exception.keeper.NotFoundPrimaryKeyException;
import com.cc.exception.keeper.UpdateDoDeleteException;
import com.cc.util.Page;
import java.util.List;


/**
 * Created by Marvin on 2016/8/24.
 * 管理实体的抽象类
 */
public class AbstractKeeper<T extends AbstractEntity, Q extends AbstractQuery, M extends AbstractMapper<T,Q>> {

    protected M mapper;

    public AbstractKeeper(M mapper) {
        this.mapper = mapper;
    }

    public T query(Q query){ return mapper.selectUniqueByExample(query); }

    public T query(Long id){ return mapper.selectByPrimaryKey(id); }

    public Integer count(Q query) { return mapper.countByExample(query); }

    // 查询出全部,最多不超过5000
    public List<T> queryList(Q query){
        query.setPageSize(5000);
        query.setPageNumber(1);
        return mapper.selectByExample(query); }

    // 查询出一页
    public Page<T> queryPage(Q query) {

        Page<T> page = new Page<>(query.getPageNumber(),query.getPageSize());
        page.setEntityTotal(mapper.countByExample(query));
        page.setData(mapper.selectByExample(query));
        return page;
    }

    public void delete(T entity) {
        if (entity.getId() == null) { throw new NotFoundPrimaryKeyException(); }
        //if (entity.getUpdator() == null) { throw new NotFoundUpdatorException(); }

        if (mapper.deleteByPrimaryKey(entity) == 0) {
            throw new BusinessException("没有删除到记录");
        }
    }

    public void deleteWithLock(T entity) {
        if (entity.getId() == null) { throw new NotFoundPrimaryKeyException(); }
        if (entity.getModifyTime() == null) { throw new NotFoundModifyTimeException(); }
        //if (entity.getUpdator() == null) { throw new NotFoundUpdatorException(); }

        if (mapper.deleteWithLockByPrimaryKey(entity) == 0) {
            throw new BusinessException("删除失败,请重试");
        }
    }

    public T update(T entity){
        if (entity.getId() == null) { throw new NotFoundPrimaryKeyException(); }
        //if (entity.getUpdator() == null) { throw new NotFoundUpdatorException(); }
        if (entity.getDeleted()) {throw new UpdateDoDeleteException(); }

        if (mapper.updateByPrimaryKey(entity) == 0) {
            throw new BusinessException("没有更新到记录");
        }
        return mapper.selectByPrimaryKey(entity.getId());
    }

    public T updateWithLock(T entity){
        if (entity.getId() == null) { throw new NotFoundPrimaryKeyException(); }
        if (entity.getModifyTime() == null) { throw new NotFoundModifyTimeException(); }
        //if (entity.getUpdator() == null) { throw new NotFoundUpdatorException(); }
        if (entity.getDeleted()) {throw new UpdateDoDeleteException(); }

        if (mapper.updateWithLockByPrimaryKey(entity) == 0) {
            throw new BusinessException("更新失败,请重试");
        }

        return mapper.selectByPrimaryKey(entity.getId());
    }

    public T insert(T entity){

        //if (entity.getCreator() == null) { throw new NotFoundCreatorException(); }
        mapper.insert(entity);
        return mapper.selectByPrimaryKey(entity.getId());

    }



}
