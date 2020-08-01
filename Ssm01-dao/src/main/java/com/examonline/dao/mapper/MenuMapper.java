package com.examonline.dao.mapper;

import com.examonline.common.base.BaseMapper;
import com.examonline.entity.Menu;

import java.util.List;

/**
 * @version V1.0
 * @date 2019/04/04
 * @author donghao
 * @description 权限表对应的mapper接口
 * @className MenuMapper
 * @packageName com.examonline.dao.mapper
 * @copyright(C) www.bosssoft.com.cn
 */

public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * @description 遍历权限表
     * 返回所有权限
     * @return
     */
    public List<Menu> getAll();

    /**
     * @description 查询单个权限
     * @param menuId
     * @return
     */
    public Menu getMenuById(int menuId);

    /**
     * 获取用户权限
     * @param userAccount
     * @return
     */
    public Menu getMenuByUserAccount(String userAccount);
}
