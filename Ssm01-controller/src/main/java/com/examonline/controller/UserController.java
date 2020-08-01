package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.common.statisc.PassProperty;
import com.examonline.entity.Department;
import com.examonline.entity.User;
import com.examonline.service.DepartmentService;
import com.examonline.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @version V1.0
 * @date 2019/04/04
 * @descripiton 系统用户controller，包含登陆，注册等多个接口
 * @author donghao
 * @className UserController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@RequestMapping(value = "/user")
@Controller
public class UserController{
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * @description 用于系统用户登陆
     * @param requestUser
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String userLogin(User requestUser) throws Exception {
        String userAccount = requestUser.getUserAccount();
        User user = userService.getUserByUserAccount(userAccount);
        JSONObject json= new JSONObject();
        if (user == null){
            throw new Exception("该用户不存在");
        }else {
            if (!requestUser.getUserPassword().equals(user.getUserPassword())){
                throw new Exception("用户名或密码错误");
            }else {
                json.put("user", JSONObject.toJSON(user));
                return json.toJSONString();
            }
        }
    }

    /**
     * @description 用于系统用户注册及添加
     * @param requestUser
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String userRegister(User requestUser)throws Exception{
            if (userService.ifExistsUser(requestUser)){
                throw new Exception("用户名已存在");
            }else {
                UUID uuid = UUID.randomUUID();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                requestUser.setUserId(uuid.toString());
                requestUser.setDepartmentId(102);
                requestUser.setUserCreateDate(df.format(new Date()));
                requestUser.setUserPassword(PassProperty.PASSWORD);
                userService.save(requestUser);
                JSONObject json = new JSONObject();
                json.put("user",JSONObject.toJSON(requestUser));
                return json.toJSONString();
            }
    }

    /**
     * @description 删除系统用户
     * @param requestUser
     * @throws Exception
     */
    @CrossOrigin
    @RequestMapping(value = "/del",method = RequestMethod.DELETE,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public void delUser(User requestUser) throws Exception{
        if (requestUser.getUserId() == null){
            throw new Exception("该用户为空");
        }
        String userAccount = requestUser.getUserAccount();
        if (userAccount == null){
            throw new Exception("该用户名不存在");
        }else {
            userService.deleteById(userAccount);
        }
    }

    /**
     * @description 修改用户
     * @param requestUser
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String updateUser(User requestUser) throws Exception{
        User user = userService.getRequestUser(requestUser);
        JSONObject json = new JSONObject();
        if (user == null){
            throw new Exception("用户不存在");
        }else{
            userService.update(user);
            json.put("user",JSONObject.toJSON(user));
            return json.toJSONString();
        }
    }

    /**
     * @description 获取系统所有用户并分页返回
     * @param startPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getUsers",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String queryUsers(int startPage,int pageSize) throws Exception{

        PageHelper.startPage(startPage,pageSize);
        List<User> users = userService.queryAll();
        for (User user : users){
            Department department = departmentService.queryById(user.getDepartmentId());
            System.out.println(user.getDepartmentId());
            user.setDepartment(department);
        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        JSONObject json = new JSONObject();
        json.put("users",JSONObject.toJSON(pageInfo));
        return json.toJSONString();
    }

    /**
     * @descripiton 获取所有阅卷官
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getCorrectors",method = RequestMethod.POST,produces = {"application/json;chartset=utf-8"})
    public String queryCorrectors() throws Exception{
        JSONObject json = new JSONObject();
        List<User> list = userService.queryCorrectors();
        if (list == null){
            throw new Exception("系统中阅卷官为空");
        }else {
            json.put("correctors",JSONObject.toJSON(list));
            return json.toJSONString();
        }
    }
}