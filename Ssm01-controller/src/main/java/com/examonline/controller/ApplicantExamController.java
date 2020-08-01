package com.examonline.controller;

import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.ApplicantExam;
import com.examonline.service.ApplicantExamService;
import com.examonline.service.ApplicantService;
import com.examonline.service.ExamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2019/04/05
 * @className ApplicantExamController
 * @packageName com.examonline.controller
 * @description 应聘者考试控制类接口
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/applicantExam")
public class ApplicantExamController {
    @Autowired
    private ApplicantExamService applicantExamService;
    @Autowired
    private ExamService examService;
    @Autowired
    private ApplicantService applicantService;

    private Logger logger = LoggerFactory.getLogger(ApplicantExamController.class);

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getApplicantExam",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getExam(String applicantId) throws Exception{
        if (applicantId == null){
            throw new Exception("参数为空");
        }else {
            List<ApplicantExam> applicantExams = applicantExamService.queryExamsByApplicantId(applicantId);
            if (applicantExams == null){
                throw new Exception("数据为空");
            }else {
                for (ApplicantExam applicantExam : applicantExams){
                    applicantExam.setExam(examService.queryById(applicantExam.getExamId()));
                }
                JSONObject json = new JSONObject();
                json.put("exams", JSONObject.toJSON(applicantExams));
                return json.toJSONString();
            }
        }
    }

    /**
     * 更新操作，阅卷官阅卷使用
     * @param requestApplicantExam
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/updateApplicantExam",method = RequestMethod.PUT,produces = {"application/json;charset=utf-8"})
    public String updateApplicantExam(ApplicantExam requestApplicantExam) throws Exception{
        if (requestApplicantExam == null ){
            throw new Exception("参数对象为空");
        }else {
            ApplicantExam applicantExam = applicantExamService.getRequestApplicantExam(requestApplicantExam);
            applicantExamService.update(applicantExam);
            return "success";
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getApplicantExams",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getApplicantExams(int startPage,int pageSize) throws Exception{
        PageHelper.startPage(startPage,pageSize);
        List<ApplicantExam> applicantExams = applicantExamService.queryAll();
        if (applicantExams == null){
            throw new Exception("系统数据为空");
        }else {
            for (ApplicantExam applicantExam : applicantExams){
                applicantExam.setExam(examService.queryById(applicantExam.getExamId()));
                applicantExam.setApplicant(applicantService.queryById(applicantExam.getApplicantId()));
            }
            PageInfo<ApplicantExam> pageInfo = new PageInfo<>(applicantExams);
            JSONObject json = new JSONObject();
            json.put("applicantExams",JSONObject.toJSON(pageInfo));
            return json.toJSONString();
        }
    }
}
