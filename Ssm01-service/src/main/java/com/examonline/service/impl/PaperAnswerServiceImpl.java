
package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.PaperAnswerMapper;
import com.examonline.entity.PaperAnswer;
import com.examonline.service.ExceptionService;
import com.examonline.service.PaperAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @version V1.0
 * @author Administrator
 * @date 2019/4/8 10:18
 */

@Service
public class PaperAnswerServiceImpl extends BaseServiceImpl<PaperAnswer>
        implements PaperAnswerService,ExceptionService {

    @Autowired
    private PaperAnswerMapper paperAnswerMapper;

    @Override
    public boolean ifExists(PaperAnswer paperAnswer) {
        boolean flag = false;
        List<PaperAnswer> paperAnswers = paperAnswerMapper.selectAll();
        for (PaperAnswer paperAnswer1 : paperAnswers){
            if (paperAnswer1.getApplicantExamId() == paperAnswer.getApplicantExamId()){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public List<PaperAnswer> getByApplicantExam(int applicantExamId) {
        Example example = new Example(PaperAnswer.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicantExamId",applicantExamId);
        return paperAnswerMapper.selectByExample(example);
    }

    @Override
    public PaperAnswer getPaperAnswer(PaperAnswer paperAnswer){
        Example example = new Example(PaperAnswer.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicantExamId",paperAnswer.getApplicantExamId());
        criteria.andEqualTo("questionId",paperAnswer.getQuestionId());
        PaperAnswer paperAnswer1 =  paperAnswerMapper.selectByExample(example).get(0);
        paperAnswer1.setPaperUserAnswer(paperAnswer.getPaperUserAnswer());
        if (paperAnswer.getPaperAnswerPicture() != null){
            paperAnswer1.setPaperAnswerPicture(paperAnswer.getPaperAnswerPicture());
        }else {
            paperAnswer1.setPaperAnswerPicture("");
        }
        return paperAnswer1;
    }

    @Override
    public void catchException() throws Exception {
        throw new Exception("PaperAnswerServiceImpl捕捉到异常");
    }
}
