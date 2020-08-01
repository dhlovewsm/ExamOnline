package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.ExamMapper;
import com.examonline.entity.Exam;
import com.examonline.entity.Paper;
import com.examonline.service.ExamService;
import com.examonline.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/3/28 17:20
 * @className ExamServiceImpl
 * @packageName com.examonline.service.impl
 * @description 考试业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("examService")
public class ExamServiceImpl extends BaseServiceImpl<Exam>
        implements ExamService,ExceptionService {
    @Autowired
    private ExamMapper examMapper;

    /**
     * @description 用于添加时判断是否存在
     * @param exam
     * @return
     */
    @Override
    public boolean ifExistsExam(Exam exam){
        String examId = exam.getExamId();
        Exam exam1 = examMapper.selectByPrimaryKey(examId);
        if (exam1 != null){
            return true;
        }else {
            return false;
        }
    }

    /**
     * @description 用于更新,将请求过来的Exam对象进行转换
     * @param requestExam
     * @return
     * @throws Exception
     */
    @Override
    public Exam getRequestExam(Exam requestExam) throws Exception {
        Exam exam = examMapper.selectByPrimaryKey(requestExam.getExamId());
        if (exam == null){
            throw new Exception("对象为空");
        }else {
            exam.setCompanyId(requestExam.getCompanyId());
            exam.setExamName(requestExam.getExamName());
            return exam;
        }
    }
    @Override
    public List<Exam> queryExamsByApplicantAccount(String applicantAccount){
        return examMapper.queryExamsByApplicantAccount(applicantAccount);
    }

    @Override
    public List<Exam> queryExamsByApplicantId(String applicantId) {
        return examMapper.queryExamsByApplicantId(applicantId);
    }

    @Override
    public List<Exam> getExamsByUserId(String userId){
        Example example = new Example(Exam.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        List<Exam> exams = examMapper.selectByExample(example);
        return exams;
    }

    @Override
    public void catchException() throws Exception {
        throw new Exception("ExamServiceImpl捕捉到异常");
    }
}
