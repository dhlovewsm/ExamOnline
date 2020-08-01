package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.QuestionMapper;
import com.examonline.entity.Question;
import com.examonline.service.ExceptionService;
import com.examonline.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/27 11:44
 * @className QuestionServiceImpl
 * @packageName com.examonline.service.impl
 * @description 试题业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl<Question>
        implements QuestionService,ExceptionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * @description 用于更新,将请求的Question进行转换
     * @param requestQuestion
     * @return
     * @throws Exception
     */
    @Override
    public Question getRequestQuestion(Question requestQuestion) throws Exception {
        String questionId = requestQuestion.getQuestionId();
        System.out.println(questionId);
        Question question = questionMapper.selectByPrimaryKey(questionId);
        if (question == null){
            throw new Exception("对象为空");
        }else {
            question.setBankId(requestQuestion.getBankId());
            question.setTypeId(requestQuestion.getTypeId());
            question.setQuestionStatus(requestQuestion.getQuestionStatus());
            question.setQuestionDifficulty(requestQuestion.getQuestionDifficulty());
            question.setQuestionText(requestQuestion.getQuestionText());
            question.setQuestionOption(requestQuestion.getQuestionOption());
            question.setQuestionAnswer(requestQuestion.getQuestionAnswer());
            return question;
        }
    }

    /**
     * @description 用于添加,判断是否存在
     * @param question
     * @return
     */
    @Override
    public boolean ifExistsQuestion(Question question) throws Exception {
        String questionId = question.getQuestionId();
        if (questionId == null){
            throw new Exception("参数为空");
        }else{
            Question question1 = questionMapper.selectByPrimaryKey(questionId);
            if (question1 != null){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public List<Question> filtQuestions(int bankId, int typeId, int difficulty){
        Example example = new Example(Question.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bankId",bankId);
        criteria.andEqualTo("typeId",typeId);
        criteria.andEqualTo("questionDifficulty",difficulty);
        List<Question> questions = questionMapper.selectByExample(example);
        return questions;
    }


    @Override
    public void catchException() throws Exception {
        throw new Exception("QuestionServiceImpl捕捉到异常");
    }
}
