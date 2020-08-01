package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.ApplicantExamMapper;
import com.examonline.entity.ApplicantExam;
import com.examonline.entity.Exam;
import com.examonline.service.ApplicantExamService;
import com.examonline.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/**
 * @version V1.0
 * @date 2019/04/03
 * @author donghao
 * @className ApplicantExamServiceImpl
 * @packageName com.examonline.service.impl
 * @description 应聘者考试业务实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("applicantExamService")
public class ApplicantExamServiceImpl extends BaseServiceImpl<ApplicantExam>
        implements ApplicantExamService,ExceptionService {
    @Autowired
    private ApplicantExamMapper applicantExamMapper;

    @Override
    public List<ApplicantExam> queryExamsByApplicantId(String applicantId) {
        Example example = new Example(ApplicantExam.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicantId",applicantId);
        List<ApplicantExam> list = applicantExamMapper.selectByExample(example);
        return list;
    }

    @Override
    public List<ApplicantExam> getByExamId(String examId) {
        Example example = new Example(ApplicantExam.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("examId",examId);
        return applicantExamMapper.selectByExample(example);
    }

    @Override
    public ApplicantExam getByApplicantAndExam(String applicantId, String examId) {
        Example example = new Example(ApplicantExam.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicantId",applicantId);
        criteria.andEqualTo("examId",examId);
        return applicantExamMapper.selectByExample(example).get(0);
    }

    @Override
    public ApplicantExam getRequestApplicantExam(ApplicantExam requestApplicantExam) {
        ApplicantExam applicantExam = applicantExamMapper.selectByPrimaryKey(requestApplicantExam.getApplicantExamId());
        applicantExam.setApplicantExamScore(requestApplicantExam.getApplicantExamScore());
        applicantExam.setApplicantExamLabel(requestApplicantExam.getApplicantExamLabel());
        applicantExam.setApplicantExamStatus(1);
        return applicantExam;
    }

    @Override
    public void catchException() throws Exception {
        throw new Exception("ApplicantExamServiceImpl捕捉到异常");
    }
}
