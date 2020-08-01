package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.common.statisc.PassProperty;
import com.examonline.entity.Applicant;
import com.examonline.entity.Resume;
import com.examonline.service.ApplicantService;
import com.examonline.service.ResumeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/25 22:10
 * @description 应聘者controller，包含关于应聘者的多种接口，如登陆，注册等
 * @className ApplicantController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@RequestMapping(value = "/applicant")
@Controller
public class ApplicantController {
    private Logger logger = LoggerFactory.getLogger(ApplicantController.class);
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private ResumeService resumeService;

    /**
     * @description 应聘者登陆
     * @param requestApplicant
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String applicantLogin(Applicant requestApplicant) throws Exception {
        String applicantAccount = requestApplicant.getApplicantAccount();
        Applicant applicant = applicantService.getApplicantByApplicantAccount(applicantAccount);
        logger.info("当前登陆的应聘者用户名为："+applicantAccount);
        JSONObject json= new JSONObject();
        if (applicant == null){
            throw new Exception("该用户不存在,请先注册");
        }else {
            if (!requestApplicant.getApplicantPassword().equals(applicant.getApplicantPassword())){
                throw new Exception("用户名或密码错误");
            }else {
                logger.info("已在系统中获取到该用户......");
                json.put("applicant", JSONObject.toJSON(applicant));
                logger.info("成功转化为json数据并返回......");
                return json.toJSONString();
            }
        }
    }

    /**
     * @description 应聘者注册
     * @param requestApplicant
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public String applicantRegister(Applicant requestApplicant)throws Exception{
        if (applicantService.ifExistsApplicant(requestApplicant)){
            throw new Exception("用户名已经被使用，请重新输入");
        }else {
                logger.info("为应聘者生成UUID......");
                UUID uuid = UUID.randomUUID();
                Resume resume = new Resume();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                requestApplicant.setApplicantId(String.valueOf(uuid));
                requestApplicant.setApplicantCreateDate(df.format(new Date()));
                logger.info("正在写入数据库......");
                applicantService.save(requestApplicant);
                logger.info("注册成功......");
                resume.setApplicantId(requestApplicant.getApplicantId());
                logger.info("正在为用户生成对应简历......");
                resumeService.save(resume);
                logger.info("生成简历成功......");
                JSONObject json = new JSONObject();
                json.put("applicant",JSONObject.toJSON(requestApplicant));
                return json.toJSONString();
            }
    }

    /**
     * 返回系统中所有的应聘者
     * @param startPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getApplicants",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getApplicants(int startPage,int pageSize) throws Exception{
        PageHelper.startPage(startPage,pageSize);
        List<Applicant> applicants = applicantService.queryAll();
        logger.info("查询数据库完成......");
        if (applicants == null){
            throw new Exception("系统数据为空");
        }else {
            logger.info("已成功获取到系统数据......");
            logger.info("正在进行分页操作......");
            PageInfo<Applicant> pageInfo = new PageInfo<>(applicants);
            JSONObject applicantsJson = new JSONObject();
            applicantsJson.put("applicants",JSONObject.toJSON(pageInfo));
            logger.info("正在返回数据......");
            return applicantsJson.toJSONString();
        }
    }

    /**
     * @description 系统用户删除应聘者信息
     * @param idArray
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/del",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    public void delApplicant(String idArray) throws Exception{
        List<String> applicantIds = JSONObject.parseArray(idArray,String.class);
        if (applicantIds == null){
            throw new Exception("参数为空");
        }else {
            for (String applicantId : applicantIds){
                logger.info("系统正在删除......");
                applicantService.deleteById(applicantId);
                logger.info("删除成功......");
            }
        }
    }

    /**
     * @description 系统用户在后台更新应聘者
     * @param requestApplicant
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String updateApplicant(Applicant requestApplicant) throws Exception{
        Applicant applicant = applicantService.getRequestApplicant(requestApplicant);
        JSONObject json = new JSONObject();
        if (applicant == null){
            throw new Exception("用户不存在");
        }else {
            logger.info("已获取到参数......");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            applicant.setApplicantCreateDate(df.format(new Date()));
            logger.info("正在更新......");
            applicantService.update(applicant);
            logger.info("更新完成......");
            json.put("applicant",JSONObject.toJSON(applicant));
            logger.info("正在返回数据......");
            return json.toJSONString();
        }
    }

    /**
     * @description 系统用户在后台添加应聘者
     * @param requestApplicant
     * @return
     * @throws Exception
     */

    @RequestMapping(value = "/add",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    @CrossOrigin
    public String addApplicant(Applicant requestApplicant) throws Exception{
        Applicant applicant = applicantService.getRequestApplicant(requestApplicant);
        if (applicant == null){
            throw new Exception("用户为空");
        }else {
            if ("".equals(applicant.getApplicantAccount())||
                    "".equals(applicant.getApplicantEmail())||
                    "".equals(applicant.getApplicantPassword())){
                throw new Exception("用户信息为空");
            }else {
                if (applicantService.ifExistsApplicant(applicant)){
                    throw new Exception("用户已存在");
                }else {
                    logger.info("系统正在添加......");
                    JSONObject json = new JSONObject();
                    UUID uuid = UUID.randomUUID();
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    applicant.setApplicantId(String.valueOf(uuid));
                    applicant.setApplicantPassword(PassProperty.PASSWORD);
                    applicant.setApplicantCreateDate(df.format(new Date()));
                    applicantService.save(applicant);
                    logger.info("添加成功......");
                    json.put("applicant",JSONObject.toJSON(applicant));
                    return json.toJSONString();
                }
            }
        }
    }

    /**
     * @description 通过应聘部门查询应聘者
     * @param departmentId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/queryApplicantsByDept",method = RequestMethod.POST,produces = {"application/json;chatset=utf-8"})
    public String queryApplicantsByDept(Integer departmentId) throws Exception{
        if (departmentId == null){
            throw new Exception("参数为空");
        }else {
            List<Applicant> list = applicantService.queryApplicantsByDepartmentId(departmentId);
            JSONObject json = new JSONObject();
            json.put("applicants",JSONObject.toJSON(list));
            return json.toJSONString();
        }
    }

    /**
     * @description 应聘者更新简历
     * @param requestResume
     * @return
     * @throws Exception
     */

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/updateResume",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String updateResume(Resume requestResume) throws Exception{
        if (requestResume == null){
            throw new Exception("参数为空");
        }else {
            resumeService.update(requestResume);
            return "success";
        }
    }

    /**
     * @description 获取应聘人员的简历表
     * @param applicantAccount
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getResume",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getResumeByApplicantAccount(String applicantAccount) throws Exception{
        if (applicantAccount == null){
            throw new Exception("参数为空");
        }else {
            Resume resume = resumeService.getResumeByApplicantAccount(applicantAccount);
            JSONObject json = new JSONObject();
            json.put("resume",JSONObject.toJSON(resume));
            return json.toJSONString();
        }
    }
}
