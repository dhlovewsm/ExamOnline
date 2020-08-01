package com.examonline.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.*;
import com.examonline.entity.*;
import com.examonline.service.ExceptionService;
import com.examonline.service.PaperService;
import com.examonline.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/27 14:13
 * @className PaperServiceImpl
 * @packageName com.examonline.service.impl
 * @descripiton 试卷业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("paperService")
public class PaperServiceImpl extends BaseServiceImpl<Paper>
        implements PaperService,ExceptionService {
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private PaperQuestionMapper paperQuestionMapper;
    @Resource
    private QuestionServiceImpl questionService;
    @Autowired
    private ApplicantExamMapper applicantExamMapper;
    @Autowired
    private ExamMapper examMapper;

    /**
     * @description 用于添加,判断是否存在
     * @param paper
     * @return
     */
    @Override
    public boolean ifExistsPaper(Paper paper){
        Paper paper1 = paperMapper.selectByPrimaryKey(paper.getPaperId());
        if (paper1 != null){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public Paper getRequestPaper(Paper requestPaper) throws Exception {
        Paper paper = paperMapper.selectByPrimaryKey(requestPaper.getPaperId());
        if (paper == null){
            throw new Exception("不存在该试卷");
        }else {
            paper.setCompanyId(requestPaper.getCompanyId());
            paper.setPaperCreator(requestPaper.getPaperCreator());
            paper.setPaperDescription(requestPaper.getPaperDescription());
            paper.setPaperCreateDate(requestPaper.getPaperCreateDate());
            paper.setPaperDifficulty(requestPaper.getPaperDifficulty());
            paper.setPaperName(requestPaper.getPaperName());
            paper.setPaperStatus(requestPaper.getPaperStatus());
            paper.setPaperTotalScore(requestPaper.getPaperTotalScore());
            paper.setPaperTypeId(requestPaper.getPaperTypeId());
            paper.setPaperVersion(requestPaper.getPaperVersion());
            return paper;
        }
    }

    @Override
    public List<Paper> queryPapersByType(String typeName)throws Exception{
        return paperMapper.queryPapersByType(typeName);
    }

    @Override
    public List<Paper> queryPapersByTypeId(int paperTypeId){
        Example example = new Example(Paper.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paperTypeId",paperTypeId);
        List<Paper> papers = paperMapper.selectByExample(example);
        return papers;
    }

    /**
     * @description 组卷算法
     * @param idArray
     * @param easyNum
     * @param mediumNum
     * @param difficultNum
     * @param typeId
     */
    @Override
    public void createPaper(String paperId, String idArray, int easyNum, int mediumNum,
                            int difficultNum, int typeId, int questionScore){
        Random random = new Random();
        //用于获取随机题目
        List<Integer> bankIds = JSONObject.parseArray(idArray,Integer.class);
        PaperQuestion paperQuestion = new PaperQuestion();
        List<Question> easyTotalList = new ArrayList<>();
        List<Question> mediumTotalList = new ArrayList<>();
        List<Question> difficultTotalList = new ArrayList<>();
        for (Integer bankId : bankIds){
            List<Question> easyList = questionService.filtQuestions(bankId,typeId,1);
            List<Question> mediumList = questionService.filtQuestions(bankId,typeId,2);
            List<Question> difficultList = questionService.filtQuestions(bankId,typeId,3);
            easyTotalList.addAll(easyList);
            mediumTotalList.addAll(mediumList);
            difficultTotalList.addAll(difficultList);
        }
        System.out.println(difficultTotalList.size());
        createQuestions(paperId, easyNum, questionScore,random, paperQuestion, easyTotalList, easyTotalList.size());
        createQuestions(paperId, mediumNum, questionScore,random,  paperQuestion, mediumTotalList, mediumTotalList.size());
        createQuestions(paperId,difficultNum,questionScore,random,paperQuestion,difficultTotalList,difficultTotalList.size());

    }


    private void createQuestions(String paperId, int num, int questionScore,Random random, PaperQuestion paperQuestion,
                                 List<Question> easyTotalList, int size) {
        List<Question> questions = new ArrayList<Question>();
        int i = 0;
        while(i<=num-1){
            Question question = easyTotalList.get(random.nextInt(size));
            if (!exists(questions,question)){
                questions.add(question);
                i++;
            }

        }
        for (Question q : questions){
            paperQuestion.setQuestionId(q.getQuestionId());
            paperQuestion.setPaperId(paperId);
            paperQuestion.setQuestionScore(questionScore);
            paperQuestionMapper.insert(paperQuestion);
        }
    }

    /**
     * @description 自动阅卷，为每一道题自动识别答案，并给分
     * @param paperAnswer
     */
    @Override
    public void correctQuestion(PaperAnswer paperAnswer) {
        Question question = questionService.queryById(paperAnswer.getQuestionId());
        ApplicantExam applicantExam = applicantExamMapper.selectByPrimaryKey(paperAnswer.getApplicantExamId());
        Exam exam = examMapper.selectByPrimaryKey(applicantExam.getExamId());
        Example example = new Example(PaperQuestion.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("paperId",exam.getPaperId());
        List<PaperQuestion> paperQuestions = paperQuestionMapper.selectByExample(example);
        for (PaperQuestion paperQuestion : paperQuestions){
            Question systemQuestion = questionService.queryById(paperQuestion.getQuestionId());
            if (systemQuestion.getQuestionId().equals(question.getQuestionId())){
                String[] systemAnswerArray = systemQuestion.getQuestionAnswer().split(";");
                String[] userAnswerArray = paperAnswer.getPaperUserAnswer().split(";");
                Arrays.sort(systemAnswerArray);
                Arrays.sort(userAnswerArray);
                if (Arrays.equals(userAnswerArray,systemAnswerArray)){
                    paperAnswer.setQuestionScore(paperQuestion.getQuestionScore());
                }else {
                    paperAnswer.setQuestionScore(0);
                }
            }
        }
    }
    public boolean exists(List<Question> questions,Question question){
        int i;
        for (i= 0;i<questions.size();i++){
            if(questions.get(i).getQuestionId().equals(question.getQuestionId())){
                return true;
            }
        }
        if (i == questions.size()){
            return false;
        }

        return true;
    }

    @Override
    public void catchException() throws Exception {
        throw new Exception("PaperServiceImpl捕捉到异常");
    }
}
