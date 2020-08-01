package com.examonline.dao.mapper;

import com.examonline.common.base.BaseMapper;
import com.examonline.entity.Exam;

import java.util.List;

/**
 * @version V1.0
 * @date 2019/04/04
 * @author donghao
 * @description 考试实体类对应的mapper接口
 * @className ExamMapper
 * @packageName com.examonline.dao.mapper
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ExamMapper extends BaseMapper<Exam> {
    /**
     * @description 获取应聘人员的所有考试信息
     * @param applicantAccount
     * @return
     */
    public List<Exam> queryExamsByApplicantAccount(String applicantAccount);

    /**
     * @description 通过应聘者ID获取考试信息
     * @param applicantId
     * @return
     */
    public List<Exam> queryExamsByApplicantId(String applicantId);
}
