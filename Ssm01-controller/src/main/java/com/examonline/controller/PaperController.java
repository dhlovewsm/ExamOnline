package com.examonline.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.examonline.common.util.Base64Util;
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
import java.util.*;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/27 14:22
 * @description 试卷controller，包含试卷生成，删除等多个接口
 * @className PaperController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@Controller
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private PaperService paperService;
    @Autowired
    private PaperQuestionService paperQuestionService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private PaperTypeService paperTypeService;
    @Autowired
    private PaperAnswerService paperAnswerService;
    @Autowired
    private ApplicantExamService applicantExamService;

    private Base64Util base64Util;

    private static final Logger logger = LoggerFactory.getLogger(PaperController.class);

    /**
     * @param startPage
     * @param pageSize
     * @return
     * @throws Exception
     * @description 获取试卷列表并分页，以json返回
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getPapers", method = RequestMethod.POST, produces = {"appication/json;charset = utf-8"})
    public String getPapers(int startPage, int pageSize) throws Exception {
        PageHelper.startPage(startPage, pageSize);
        List<Paper> papers = paperService.queryAll();
        for (Paper paper : papers) {
            paper.setCompany(companyService.queryById(paper.getCompanyId()));
            paper.setType(paperTypeService.queryById(paper.getPaperTypeId()));
        }
        PageInfo<Paper> pageInfo = new PageInfo<>(papers);
        JSONObject json = new JSONObject();
        json.put("papers", JSONObject.toJSON(pageInfo));
        return json.toJSONString();
    }

    /**
     * @param requestPaper
     * @return
     * @throws Exception
     * @description 更改试卷信息
     */
    @CrossOrigin
    @RequestMapping(value = "/updatePaper", method = RequestMethod.PUT, produces = {"application/json;charset = utf-8"})
    @ResponseBody
    public String updatePaper(Paper requestPaper) throws Exception {
        Paper paper = paperService.getRequestPaper(requestPaper);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paper.setPaperUpdateDate(df.format(new Date()));
        paperService.update(paper);
        return "success";
    }

    /**
     * @param idArray
     * @return
     * @throws Exception
     * @description 删除一个或多个试卷
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/deletePaper", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String deletePaper(String idArray) throws Exception {
        List<String> list = JSONArray.parseArray(idArray, String.class);
        for (String paperId : list) {
            paperService.deleteById(paperId);
        }
        return "success";
    }

    /**
     * @param typeId
     * @return
     * @throws Exception
     * @description 通过paper的type属性值获取paper列表
     */
    @CrossOrigin
    @RequestMapping(value = "/queryPapersByType", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String queryPapersByType(String typeId) throws Exception {
        if ("".equals(typeId)) {
            throw new Exception("参数为空");
        } else {
            List<Paper> papers = paperService.queryPapersByType(typeId);
            if (papers == null) {
                throw new Exception("系统没有此类试卷");
            } else {
                JSONObject json = new JSONObject();
                json.put("papers", JSONObject.toJSON(papers));
                return json.toJSONString();
            }
        }
    }

    /**
     * @param parameterArray 参数数组
     * @return
     * @throws Exception
     * @description 创建试卷，组卷
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addPaper", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String addPaper(String parameterArray, int paperTotalScore) throws Exception {
        UUID uuid = UUID.randomUUID();
        Paper paper = new Paper();
        paper.setPaperId(String.valueOf(uuid));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        paper.setPaperCreateDate(df.format(new Date()));
        List<PaperParameter> list = JSONObject.parseArray(parameterArray, PaperParameter.class);
        PaperParameter parameter = list.get(0);
        paper.setPaperTypeId(parameter.getPaperTypeId());
        paper.setType(paperTypeService.queryById(parameter.getTypeId()));
        paper.setPaperDifficulty(parameter.getPaperDifficulty());
        paper.setCompanyId(parameter.getCompanyId());
        paper.setCompany(companyService.queryById(parameter.getCompanyId()));
        paper.setPaperName(parameter.getPaperName());
        paper.setPaperTotalScore(paperTotalScore);
        paper.setPaperStatus(1);
        paperService.save(paper);
        for (PaperParameter parameter1 : list) {
            String paperId = String.valueOf(uuid);
            String idArray = parameter1.getIdArray();
            int easyNum = parameter1.getEasyNum();
            int mediumNum = parameter1.getMediumNum();
            int difficultNum = parameter1.getDifficultNum();
            int typeId = parameter1.getTypeId();
            int questionScore = parameter1.getQuestionScore();
            paperService.createPaper(paperId, idArray, easyNum, mediumNum, difficultNum, typeId, questionScore);
        }
        return "success";
    }

    /**
     * 后台显示
     *
     * @return
     * @throws Exception
     * @description 显示试卷，将试卷的所有题目返回
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/showPaper", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String getPaper(String paperId) throws Exception {
        if (paperId == null) {
            throw new Exception("参数为空");
        } else {
            List<PaperQuestion> paperQuestions = paperQuestionService.showPaper(paperId);
            List<Question> singleQuestions = new ArrayList<>();
            List<Question> multipleQuestions = new ArrayList<>();
            List<Question> judgementQuestions = new ArrayList<>();
            List<Question> fillInQuestions = new ArrayList<>();
            List<Question> subjectiveQuestions = new ArrayList<>();
            for (PaperQuestion paperQuestion : paperQuestions) {
                Question question = questionService.queryById(paperQuestion.getQuestionId());
                if (question.getTypeId() == 1) {
                    singleQuestions.add(question);
                }
                if (question.getTypeId() == 2) {
                    multipleQuestions.add(question);
                }
                if (question.getTypeId() == 3) {
                    judgementQuestions.add(question);
                }
                if (question.getTypeId() == 4) {
                    fillInQuestions.add(question);
                }
                if (question.getTypeId() == 5) {
                    subjectiveQuestions.add(question);
                }
            }

            JSONObject json = new JSONObject();
            json.put("single", JSONObject.toJSON(singleQuestions));
            json.put("multiple", JSONObject.toJSON(multipleQuestions));
            json.put("judgement", JSONObject.toJSON(judgementQuestions));
            json.put("fillIn", JSONObject.toJSON(fillInQuestions));
            json.put("subjective", JSONObject.toJSON(subjectiveQuestions));
            return json.toJSONString();
        }
    }

    /**
     * @param paperAnswerArray
     * @return
     * @throws Exception
     * @description 用户点击提交试卷接口
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/commitPaper", method = RequestMethod.PUT, produces = {"application/json;charset=utf-8"})
    public String commitPaper(String paperAnswerArray) throws Exception {
        if (paperAnswerArray == null) {
            throw new Exception("参数为空");
        } else {
            int score = 0;
            List<PaperAnswer> paperAnswers = JSONObject.parseArray(paperAnswerArray, PaperAnswer.class);
            int applicantExamId = paperAnswers.get(0).getApplicantExamId();
            for (PaperAnswer paperAnswer : paperAnswers) {
                PaperAnswer sumPaperAnswer = paperAnswerService.getPaperAnswer(paperAnswer);
                paperService.correctQuestion(sumPaperAnswer);
                paperAnswerService.update(sumPaperAnswer);
                score += sumPaperAnswer.getQuestionScore();
            }
            ApplicantExam applicantExam = applicantExamService.queryById(applicantExamId);
            applicantExam.setApplicantExamScore(score);
            applicantExam.setApplicantExamStatus(1);
            applicantExamService.update(applicantExam);
            return "success";
        }
    }

    /**
     * @param applicantId
     * @param examId
     * @return
     * @throws Exception
     * @description 通过应聘者ID和考试ID获取该应聘者的答案
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getAnswer", method = RequestMethod.POST, produces = {"application/json;charset=utf-8"})
    public String getUserAnswer(String applicantId, String examId) throws Exception {
        logger.info(applicantId);
        logger.info(examId);
        ApplicantExam applicantExam = applicantExamService.getByApplicantAndExam(applicantId, examId);
        List<PaperAnswer> paperAnswers = paperAnswerService.getByApplicantExam(applicantExam.getApplicantExamId());
        for (PaperAnswer paperAnswer : paperAnswers) {
            paperAnswer.setQuestion(questionService.queryById(paperAnswer.getQuestionId()));
        }
        JSONObject json = new JSONObject();
        json.put("answers", JSONObject.toJSON(paperAnswers));
        return json.toJSONString();
    }

}
