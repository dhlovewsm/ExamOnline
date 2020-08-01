package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Menu;
import com.examonline.entity.Role;
import com.examonline.entity.User;
import java.util.List;
import java.util.Set;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/04/03
 * @className UserService
 * @packageName com.examonline.service
 * @description 系统用户业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface UserService extends BaseService<User> {
    /**
     * @description 通过用户名获取系统用户
     * @param userAccount
     * @return
     */
    public User getUserByUserAccount(String userAccount);

    /**
     * @description 用于更新,将请求的User对象进行转换
     * @param requestUser
     * @return
     */
    public User getRequestUser(User requestUser);

    /**
     * @description 用于添加, 判断是否存在
     * @param user
     * @return
     */
    public boolean ifExistsUser(User user) throws Exception;

    public User getOne(String userAccount);
    public List<User> getAll();

    public List<User> queryCorrectors();

    public List<User> queryUsersByDepartmentId(int departmentId);

    public Set<Role> queryUserRoles(String userAccount);

    public Set<Menu> queryUserPermissions(String userAccount);


}
