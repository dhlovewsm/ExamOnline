package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Exam;
import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/28 17:20
 * @className ExamService
 * @packageName com.examonline.service
 * @description 考试业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ExamService extends BaseService<Exam> {

    /**
     * @description 用于添加时判断是否存在
     * @param exam
     * @return
     */
    public boolean ifExistsExam(Exam exam);

    /**
     * @description 用于更新,将请求过来的Exam对象进行转换
     * @param requestExam
     * @return
     * @throws Exception
     */
    public Exam getRequestExam(Exam requestExam) throws Exception ;

    /**
     * @description 通过用户名获取该应聘者的考试信息
     * @param applicantAccount
     * @return
     */
    public List<Exam> queryExamsByApplicantAccount(String applicantAccount);

    /**
     *
     * @param applicantId
     * @return
     */
    public List<Exam> queryExamsByApplicantId(String applicantId);

    /**
     * @descripition 通过用户ID获取阅卷的考试信息
     * @param userId
     * @return
     */
    public List<Exam> getExamsByUserId(String userId);
}
