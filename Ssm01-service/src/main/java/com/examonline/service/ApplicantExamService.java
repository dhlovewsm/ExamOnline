package com.examonline.service;


import com.examonline.common.base.BaseService;
import com.examonline.entity.ApplicantExam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @date 2019/04/03
 * @author donghao
 * @className ApplicantExamService
 * @packageName com.examonline.service
 * @description 应聘者考试service接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ApplicantExamService extends BaseService<ApplicantExam> {
    /**
     * 返回考试
     * @description 获取应聘者的考试
     * @param applicantId
     * @return
     */
    public List<ApplicantExam> queryExamsByApplicantId(String applicantId);

    public List<ApplicantExam> getByExamId(String examId);

    public ApplicantExam getByApplicantAndExam(String applicantId,String examId);

    public ApplicantExam getRequestApplicantExam(ApplicantExam requestApplicantExam);
}
