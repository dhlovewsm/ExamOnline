package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.PaperAnswer;

import java.util.List;


/**
 * @version V1.0
 * @date 2019/04/06
 * @author donghao
 * @className PaperAnswerService
 * @packageName com.examonline.service
 * @descripiton 试卷答案表的业务接口类
 */
public interface PaperAnswerService extends BaseService<PaperAnswer> {
    /**
     * 判断是否已经存在
     * @param paperAnswer
     * @return
     */
    public boolean ifExists(PaperAnswer paperAnswer);

    /**
     * 获取答案
     * @param examId
     * @return
     */
    public List<PaperAnswer> getByApplicantExam(int examId);

    public PaperAnswer getPaperAnswer(PaperAnswer paperAnswer);
}
