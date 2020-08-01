package com.examonline.common.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version V1.0
 * @author donghao
 * @className BaseMapper
 * @packageName com.examonline.common.base
 * @description 通用service，包含通用mapper的多种基础怎删改查
 * @date 2019/04/03
 * @param <T>
 * @Copyright(c) www.bosssoft.com.cn
 */

public abstract class BaseServiceImpl<T> implements BaseService<T>{

    private static final com.github.pagehelper.PageHelper PageHelper = new PageHelper();
    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    @Override
    public T queryById(String id){
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    @Override
    public T queryById(int id){
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<T> queryAll(){
        return this.mapper.select(null);
    }

    /**
     * 条件查询
     * @param param
     * @return
     */
    @Override
    public List<T> queryListByWhere(T param){
        return this.mapper.select(param);
    }

    /**
     * 查询记录数
     * @param param
     * @return
     */
    @Override
    public Integer queryCount(T param){
        return this.mapper.selectCount(param);
    }

    /**
     * 分页
     * @param param
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageInfo<T> queryPageListByWhere(T param, Integer page, Integer rows){
        com.github.pagehelper.PageHelper.startPage(page, rows);
        List<T> list = this.queryListByWhere(param);
        return new PageInfo<T>(list);

    }

    /**
     * 查询一条记录
     * @param param
     * @return
     */
    @Override
    public T queryOne(T param){
        return this.mapper.selectOne(param);
    }

    /**
     * 插入
     * @param param
     * @return
     */
    @Override
    public Integer save(T param){
        return this.mapper.insert(param);
    }

    /**
     * 新增非空字段
     * @param param
     * @return
     */
    @Override
    public Integer saveSelect(T param){
        return this.mapper.insertSelective(param);
    }

    /**
     * 根据主键更新
     * @param param
     * @return
     */
    @Override
    public Integer update(T param){
        return this.mapper.updateByPrimaryKey(param);
    }

    /**
     * 根据主键更新非空字段
     * @param param
     * @return
     */
    @Override
    public Integer updateSelective(T param){
        return this.mapper.updateByPrimaryKeySelective(param);
    }

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(String id){
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    @Override
    public Integer deleteById(Integer id){
        return this.mapper.deleteByPrimaryKey(id);
    }

    /**
     * 批量删除
     * @param clazz
     * @param values
     * @return
     */
    @Override
    public Integer deleteByIds(Class<T> clazz, List<Object> values){
        Example example = new Example(clazz);
        example.createCriteria().andIn("id", values);
        return this.mapper.deleteByExample(example);
    }

}
