package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.Applicant;
import com.examonline.entity.Company;
import com.examonline.entity.Department;
import com.examonline.entity.User;
import com.examonline.service.ApplicantService;
import com.examonline.service.CompanyService;
import com.examonline.service.DepartmentService;
import com.examonline.service.UserService;
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
 * @date 2019/3/31 20:26
 * @description 公司controller，包含公司的基础增删改查接口
 * @className CompanyController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private ApplicantService applicantService;

    /**
     * @description 获取公司列表并以json返回
     * @param companyId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getCompany",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getCompanyById(int companyId) throws Exception{
        Company company = companyService.queryById(companyId);
        if (company == null){
            throw new Exception("对象为空");
        }else {
            JSONObject json = new JSONObject();
            json.put("company",JSONObject.toJSON(company));
            return json.toJSONString();
        }
    }

    /**
     * @description 系统管理员用于添加子公司
     * @param requestCompany
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String addCompany(Company requestCompany) throws Exception{
        if (requestCompany == null){
            throw new Exception("参数为空");
        }else {
            if (companyService.ifExistsCompany(requestCompany)){
                throw new Exception("已存在");
            }else {
                companyService.save(requestCompany);
                return "success";
            }
        }
    }

    /**
     * @description 系统管理员用于删除公司
     * @param companyId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/deleteCompany",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String deleteCompany(int companyId) throws Exception{
        return "success";
    }

    /**
     * @description 返回所有公司的名称
     * @param companyId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "getCompanyName",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getCompanyNameById(int companyId) throws Exception{
        Company company = companyService.queryById(companyId);
        if (company == null){
            throw new Exception("公司不存在");
        }else {
            return company.getCompanyName();
        }
    }

    /**
     * @decription 返回所有公司以及嵌套的部门以及嵌套的系统用户信息
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/queryCompanies",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String queryCompanies() throws Exception{
        List<Company> companies = companyService.queryAll();
        if (companies == null){
            throw new Exception("系统中数据为空");
        }else {
            for (Company company : companies){
                List<Department> departments = departmentService.queryDepartmentsByCompanyId(company.getCompanyId());
                if (departments == null){
                    throw new Exception("系统中数据为空");
                }else {
                    for (Department department : departments){
                        List<User> users = userService.queryUsersByDepartmentId(department.getDepartmentId());
                        department.setUserList(users);
                    }
                }
                company.setDepartmentList(departments);
            }
            JSONObject companyJson = new JSONObject();
            companyJson.put("companies",JSONObject.toJSON(companies));
            return companyJson.toJSONString();
        }
    }

    /**
     * @description 将所有部门以及嵌套的应聘者信息返回
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/queryDepartments",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String queryDepartments() throws Exception{
        List<Department> departments = departmentService.queryAll();
        if (departments == null){
            throw new Exception("系统数据为空");
        }else {
            for (Department department : departments){
                List<Applicant> applicants = applicantService.queryApplicantsByDepartmentId(department.getDepartmentId());
                if (applicants == null){
                    throw new Exception("系统数据为空");
                }else {
                    department.setApplicantList(applicants);
                }
            }
            JSONObject departmentJson = new JSONObject();
            departmentJson.put("departments",departments);
            return departmentJson.toJSONString();
        }
    }
}
