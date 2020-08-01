package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.Applicant;
import com.examonline.entity.Department;
import com.examonline.service.ApplicantService;
import com.examonline.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/31 20:34
 * @description 部门controller，包含部门的基础增删改查接口
 * @className DepartmentController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ApplicantService applicantService;

    /**
     * @description 获取部门列表并以json返回
     * @param departmentId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getDepartment",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getDepartmentById(String departmentId) throws Exception{
        Department department = departmentService.queryById(departmentId);
        if (department == null){
            throw new Exception("对象为空");
        }else {
            JSONObject json = new JSONObject();
            json.put("department",JSONObject.toJSON(department));
            return json.toJSONString();
        }
    }

    /**
     * @descripition 系统管理员用于添加部门
     * @param requestDepartment
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addDepartment",method = RequestMethod.POST,produces = {"aplication/json;charset=utf-8"})
    public String addDepartment(Department requestDepartment) throws Exception{
        if (requestDepartment == null){
            throw new Exception("参数为空");
        }else {
            if (departmentService.ifExistsDepartment(requestDepartment)){
                throw new Exception("部门已存在");
            }else {
                departmentService.save(requestDepartment);
                return "success";
            }
        }
    }

    /**
     * @description 系统管理员用于删除部门
     * @param departmentId
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/deleteDepartment",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String deleteDepartment(int departmentId){
        try {
            departmentService.deleteById(departmentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

}
