package com.examonline.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.*;
import com.examonline.service.*;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/28 17:20、
 * @description 考试管理controller，包含发布考试，修改考试等多个基础接口
 * @className ExamController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private ApplicantExamService applicantExamService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PaperQuestionService paperQuestionService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private ApplicantService applicantService;
    @Autowired
    private PaperAnswerService paperAnswerService;

    private Logger logger = LoggerFactory.getLogger(ExamController.class);

    /**
     * @description 获取所有Exam
     * @param startPage
     * @param pageSize
     * @return list转化后的json数据
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getExams",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getExams(int startPage,int pageSize) throws Exception{
        PageHelper.startPage(startPage,pageSize);
        List<Exam> list = examService.queryAll();
        for (Exam exam : list){
            exam.setCompany(companyService.queryById(exam.getCompanyId()));
        }
        PageInfo<Exam> pageInfo = new PageInfo<>(list);
        JSONObject json = new JSONObject();
        json.put("exams",JSONObject.toJSON(pageInfo));
        return json.toJSONString();
    }

    /**
     * @description 添加Exam
     * @param requestExam
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addExam",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String addExam(String requestExam,String idArray) throws Exception{
        logger.info(requestExam);
        if (requestExam == null){
            throw new Exception("请求的exam为空");
        } else {
            Exam exam = JSONObject.parseArray(requestExam,Exam.class).get(0);
            logger.info(exam.getExamName());
            if (examService.ifExistsExam(exam)){
                throw new Exception("考试已存在");
            }else {
                UUID uuid = UUID.randomUUID();
                exam.setExamId(String.valueOf(uuid));
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                exam.setExamCreateDate(df.format(new Date()));
                exam.setExamStatus(1);
                examService.save(exam);
                List<String> applicantIds = JSONObject.parseArray(idArray,String.class);
                List<Question> questions = new ArrayList<>();
                for (String applicantId : applicantIds){
                    ApplicantExam applicantExam = new ApplicantExam();
                    PaperAnswer paperAnswer = new PaperAnswer();
                    applicantExam.setApplicantId(applicantId);
                    applicantExam.setExamId(exam.getExamId());
                    applicantExamService.save(applicantExam);
                    int applicantExamId = applicantExamService.getByApplicantAndExam(applicantId,exam.getExamId()).getApplicantExamId();
                    String paperId = exam.getPaperId();
                    List<PaperQuestion> paperQuestions = paperQuestionService.showPaper(paperId);
                    for (PaperQuestion paperQuestion : paperQuestions){
                    Question question = questionService.queryById(paperQuestion.getQuestionId());
                    questions.add(question);
                    }
                    for (Question question : questions){
                        paperAnswer.setApplicantExamId(applicantExamId);
                        paperAnswer.setPaperUserAnswer("");
                        paperAnswer.setQuestionId(question.getQuestionId());
                        paperAnswerService.save(paperAnswer);
                    }
                }
                return "success";
            }
        }
    }

    /**
     * @description 删除Exam对象
     * @param idArray
     * @return success字符串
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/deleteExam",method = RequestMethod.POST,produces = {"application/json;chartset=utf-8"})
    public String deleteExam(String idArray) throws Exception{
        List<String> list = JSONArray.parseArray(idArray,String.class);
        if (list == null){
            throw new Exception("参数为空");
        }else {
            for (String examId : list){
                examService.deleteById(examId);
            }
            return "success";
        }
    }

    /**
     * @description 更新Exam对象
     * @param requestExam
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/updateExam",method = RequestMethod.PUT,produces = {"application/json;charset=utf-8"})
    public String updateExam (Exam requestExam) throws Exception{
        Exam exam = examService.getRequestExam(requestExam);
        if (exam == null){
            throw new Exception("考试为空");
        }else {
            examService.update(exam);
            return "success";
        }
    }

    /**
     * @description 获取应聘者的考试信息
     * @param applicantId
     * @return
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getExam",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getExam(String applicantId) throws Exception{
        if (applicantId == null){
            throw new Exception("参数为空");
        }else {
            List<Exam> exams = examService.queryExamsByApplicantId(applicantId);
            if (exams == null){
                throw new Exception("数据为空");
            }else {
                JSONObject json = new JSONObject();
                json.put("exams", JSONObject.toJSON(exams));
                return json.toJSONString();
            }
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "showExamPaper",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getApplicantPaper(String examId) throws Exception{
        if (examId == null) {
            throw new Exception("参数为空");
        }else {
            Exam exam = examService.queryById(examId);
            List<PaperQuestion> paperQuestions = paperQuestionService.showPaper(exam.getPaperId());
            List<PaperQuestion> singleQuestions = new ArrayList<>();
            List<PaperQuestion> multipleQuestions = new ArrayList<>();
            List<PaperQuestion> judgementQuestions = new ArrayList<>();
            List<PaperQuestion> fillInQuestions = new ArrayList<>();
            List<PaperQuestion> subjectiveQuestions = new ArrayList<>();

            for (PaperQuestion paperQuestion : paperQuestions){
                Question question = questionService.queryById(paperQuestion.getQuestionId());
                paperQuestion.setQuestion(question);
                if (question.getTypeId() == 1){
                    singleQuestions.add(paperQuestion);
                }
                if (question.getTypeId() == 2){
                    multipleQuestions.add(paperQuestion);
                }
                if (question.getTypeId() == 3){
                    judgementQuestions.add(paperQuestion);
                }
                if (question.getTypeId() == 4){
                    fillInQuestions.add(paperQuestion);
                }
                if (question.getTypeId() == 5){
                    subjectiveQuestions.add(paperQuestion);
                }
            }

            JSONObject json = new JSONObject();
            json.put("single",JSONObject.toJSON(singleQuestions));
            json.put("multiple",JSONObject.toJSON(multipleQuestions));
            json.put("judgement",JSONObject.toJSON(judgementQuestions));
            json.put("fillIn",JSONObject.toJSON(fillInQuestions));
            json.put("subjective",JSONObject.toJSON(subjectiveQuestions));
            return json.toJSONString();
        }
    }

    /**
     * @description 返回当前登录的系统用户返回该用户阅卷的考试
     * @param userId
     * @param startPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getExamByUser",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getUserExam(String userId,int startPage,int pageSize) throws Exception{
        if (userId == null){
            throw new Exception("参数为空");
        }else{
            PageHelper.startPage(startPage,pageSize);
            List<Exam> exams = examService.getExamsByUserId(userId);
            PageInfo<Exam> pageInfo = new PageInfo<>(exams);
            JSONObject json = new JSONObject();
            json.put("exams",JSONObject.toJSON(pageInfo));
            return json.toJSONString();
        }
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getApplicantsByExam",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String getApplicantsByExam(String examId,int startPage,int pageSize)
            throws Exception{
        if (examId == null){
            throw new Exception("参数为空");
        }else {
            PageHelper.startPage(startPage,pageSize);
            List<ApplicantExam> applicantExams = applicantExamService.getByExamId(examId);
            for (ApplicantExam applicantExam : applicantExams){
                applicantExam.setApplicant(applicantService.queryById(applicantExam.getApplicantId()));
            }
            PageInfo<ApplicantExam> pageInfo = new PageInfo<>(applicantExams);
            JSONObject json = new JSONObject();
            json.put("applicants",JSONObject.toJSON(pageInfo));
            return json.toJSONString();
        }
    }
}
