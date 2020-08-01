package com.examonline.dao.mapper;


import com.examonline.entity.Menu;
import com.examonline.entity.Role;
import com.examonline.entity.User;
import com.examonline.common.base.BaseMapper;
import java.util.List;
import java.util.Set;


/**
 * @version V1.0
 * @date 2019/04/03
 * @author donghao
 * @className UserMapper
 * @packageName com.examonline.dao.mapper
 * @description 系统用户对应的mapper接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询用户角色
     * @description 获取用户角色
     * @param userAccount
     * @return
     */
    public Set<Role> queryRoles(String userAccount);

    /**
     * 查询用户权限
     * @description 获取用户权限
     * @param userAccount
     * @return
     */
    public Set<Menu> queryPermissions(String userAccount);

    /**
     * 查询单个用户
     * @description 通过系统用户的用户名获取用户
     * @param userAccount
     * @return
     */
    public User getOne(String userAccount);

    /**
     * 返回所有
     * @description 遍历数据库所有系统用户
     * @return
     */
    public List<User> getAll();

    /**
     * 返回阅卷官列表
     * @description 查询所有阅卷官
     * @return
     */
    public List<User> queryCorrectors();
}
