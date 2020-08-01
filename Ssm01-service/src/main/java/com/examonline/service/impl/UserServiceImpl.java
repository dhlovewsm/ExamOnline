package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.UserMapper;
import com.examonline.entity.Menu;
import com.examonline.entity.Role;
import com.examonline.entity.User;
import com.examonline.service.ExceptionService;
import com.examonline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Set;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/04/03
 * @className UserServiceImpl
 * @packageName com.examonline.service.impl
 * @description 系统用户业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User>
        implements UserService,ExceptionService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByUserAccount(String userAccount){
        Example example = new Example(User.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userAccount",userAccount);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0){
            return null;
        }
        return users.get(0);
    }

    /**
     * @description 用于更新,将请求的User对象进行转换
     * @param requestUser
     * @return
     */
    @Override
    public User getRequestUser(User requestUser){
        String userAccount = requestUser.getUserAccount();
        User user = userMapper.getOne(userAccount);
        user.setUserPassword(requestUser.getUserPassword());
        user.setUserName(requestUser.getUserName());
        user.setUserPhone(requestUser.getUserPhone());
        user.setUserEmail(requestUser.getUserEmail());
        user.setUserNumber(requestUser.getUserNumber());
        user.setUserIdentity(requestUser.getUserIdentity());
        user.setDepartmentId(requestUser.getDepartmentId());
        user.setUserCreateDate(requestUser.getUserCreateDate());
        user.setUserUpdateDate(requestUser.getUserUpdateDate());
        user.setUserCreator(requestUser.getUserCreator());
        user.setUserVersion(requestUser.getUserVersion());
        user.setUserStatus(requestUser.getUserStatus());
        user.setUserUpdatePerson(requestUser.getUserUpdatePerson());
        return user;
    }

    /**
     * @description 用于添加,判断是否存在
     * @param user
     * @return
     */

    @Override
    public boolean ifExistsUser(User user) throws Exception {
        String userAccount = user.getUserAccount();
        if (userAccount == null){
            throw new Exception("参数为空");
        }else {
            User user1 = getUserByUserAccount(userAccount);
            if (user1 != null){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public User getOne(String userAccount){
        return userMapper.getOne(userAccount);
    }
    @Override
    public List<User> getAll(){
        return userMapper.getAll();
    }

    @Override
    public List<User> queryCorrectors(){
        return userMapper.queryCorrectors();
    }

    /**
     * 通用公司ID获取本公司的所有系统用户
     * @param departmentId
     * @return
     */
    @Override
    public List<User> queryUsersByDepartmentId(int departmentId) {
        Example example = new Example(User.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("departmentId",departmentId);
        List<User> users = userMapper.selectByExample(example);
        return users;
    }


    @Override
    public Set<Role> queryUserRoles(String userAccount){
        return userMapper.queryRoles(userAccount);
    }

    @Override
    public Set<Menu> queryUserPermissions(String userAccount){
        return userMapper.queryPermissions(userAccount);
    }


    @Override
    public void catchException() throws Exception {
        throw new Exception("UserServiceImpl捕捉到异常");
    }
}
