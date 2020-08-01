package com.examonline.common.base;

import com.github.pagehelper.PageInfo;
import java.util.List;

/**
 * @version V1.0
 * @date 2019/04/03
 * @author donghao
 * @className BaseService
 * @packageName com.examonline.common.base
 * @description 通用service接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface BaseService<T> {

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    public T queryById(String id);

    /**
     * 根据id查询实体
     * @param id
     * @return
     */
    public T queryById(int id);

    /**
     * 查询所有
     * @return
     */
    public List<T> queryAll();

    /**
     * 条件查询
     * @param param
     * @return
     */
    public List<T> queryListByWhere(T param);

    /**
     * 查询记录数
     * @param param
     * @return
     */
    public Integer queryCount(T param);

    /**
     * 分页
     * @param param
     * @param page
     * @param rows
     * @return
     */
    public PageInfo<T> queryPageListByWhere(T param, Integer page, Integer rows);


    /**
     * 查询一条记录
     * @param param
     * @return
     */
    public T queryOne(T param);

    /**
     * 插入
     * @param param
     * @return
     */
    public Integer save(T param);

    /**
     * 新增非空字段
     * @param param
     * @return
     */
    public Integer saveSelect(T param);

    /**
     * 根据主键更新
     * @param param
     * @return
     */
    public Integer update(T param);

    /**
     * 根据主键更新非空字段
     * @param param
     * @return
     */
    public Integer updateSelective(T param);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    public Integer deleteById(String id);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    public Integer deleteById(Integer id);

    /**
     * 批量删除
     * @param clazz
     * @param values
     * @return
     */
    public Integer deleteByIds(Class<T> clazz,List<Object> values);
}
