package com.examonline.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.examonline.entity.Question;
import com.examonline.service.BankService;
import com.examonline.service.CompanyService;
import com.examonline.service.QuestionService;
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
 * @author donoghao
 * @date 2019/3/27 11:43
 * @description 试题controller，包含增删改查等多个接口
 * @className QuestionController
 * @packageName com.examonline.controller
 * @copyright(C) www.bosssoft.com.cn
 */

@RequestMapping("/question")
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private BankService bankService;
    Logger logger = LoggerFactory.getLogger(QuestionController.class);

    /**
     * @description 新增试题，手动添加
     * @param requestQuestion
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @RequestMapping(value = "/addQuestion",method = RequestMethod.POST,produces={"application/json;charset=utf-8"})
    @ResponseBody
    public String addQuestion(Question requestQuestion) throws Exception{

        logger.info("请求的question的status为："+requestQuestion.getQuestionStatus());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UUID uuid = UUID.randomUUID();
        requestQuestion.setQuestionId(String.valueOf(uuid));
        requestQuestion.setQuestionCreateDate(df.format(new Date()));
        questionService.save(requestQuestion);
        return "success";
    }

    /**
     * @description 获取所有试题并分页返回
     * @param startPage
     * @param pageSize
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getQuestions",method = RequestMethod.POST,produces = {"application/json;charset = utf-8"})
    public String getQuestions(Integer startPage,Integer pageSize) throws Exception{
        System.out.println(startPage);
        PageHelper.startPage(startPage,pageSize);
        List<Question> questions = questionService.queryAll();
        for (Question question : questions){
            question.setCompany(companyService.queryById(question.getCompanyId()));
            question.setBank(bankService.queryById(question.getBankId()));
        }
        PageInfo<Question> pageInfo = new PageInfo<>(questions);
        JSONObject json = new JSONObject();
        json.put("questions",JSONObject.toJSON(pageInfo));
        return json.toJSONString();
    }

    /**
     * @description 删除试题
     * @param idArray
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/deleteQuestion",method = RequestMethod.POST,produces = {"application/json;charset = utf-8"})
    public String deleteQuestion(String idArray) throws Exception{
        List<String> list = JSONArray.parseArray(idArray,String.class);
        if (list == null){
            throw new Exception("对象为空");
        }
        for (String  questionId : list){
            questionService.deleteById(questionId);
        }
        return "success";
    }

    /**
     * @description 更改试题
     * @param requestQuestion
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @RequestMapping(value = "/updateQuestion",method = RequestMethod.PUT,produces = {"application/json;charset = utf-8"})
    @ResponseBody
    public String updateQuestion(Question requestQuestion) throws Exception{
        Question question = questionService.getRequestQuestion(requestQuestion);
        if (question == null ){
            throw new Exception("该记录不存在");
        }else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            question.setQuestionUpdateDate(df.format(new Date()));
            questionService.update(question);
            return "success";
        }
    }

    /**
     * @descripiton 用于试题筛选，通过题库与类型筛选
     * @param idArray
     * @param typeId
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/questionFilter",method = RequestMethod.POST,produces = {"application/json;charset=utf-8"})
    public String questionFilter(String idArray,int typeId) throws Exception{
        List<Integer> bankIds = JSONObject.parseArray(idArray,Integer.class);
        int easyTotalNum = 0,mediumTotalNum = 0,difficultTotalNum = 0;
        for (Integer bankId : bankIds){
            int easyNum = questionService.filtQuestions(bankId,typeId,1).size();
            int mediumNum = questionService.filtQuestions(bankId,typeId,2).size();
            int difficultNum = questionService.filtQuestions(bankId,typeId,3).size();
            easyTotalNum += easyNum;
            mediumTotalNum +=mediumNum;
            difficultTotalNum +=difficultNum;
        }
        JSONObject json = new JSONObject();
        json.put("easyNum",easyTotalNum);
        json.put("mediumNum",mediumTotalNum);
        json.put("difficultNum",difficultTotalNum);
        return json.toJSONString();
    }
}
