package com.examonline.service.impl;

import com.examonline.common.base.BaseServiceImpl;
import com.examonline.dao.mapper.ResumeMapper;
import com.examonline.entity.Resume;
import com.examonline.service.ExceptionService;
import com.examonline.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


/**
 * @version V1.0
 * @author Administrator
 * @date 2019/4/1 9:38
 * @className ResumeServiceImpl
 * @packageName com.examonline.service.impl
 * @description 简历业务接口实现类
 * @copyright(C) www.bosssoft.com.cn
 */

@Transactional
@Service("resumeService")
public class ResumeServiceImpl extends BaseServiceImpl<Resume>
        implements ResumeService,ExceptionService {
    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public Resume getResumeByApplicantId(String applicantId){
        Example example = new Example(Resume.class,true,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applicantId",applicantId);
        Resume resume = (Resume) resumeMapper.selectByExample(example);
        return resume;
    }

    @Override
    public Resume getResumeByApplicantAccount(String applicantAccount) {
        return resumeMapper.getResumeByApplicantAccount(applicantAccount);
    }

    @Override
    public void catchException() throws Exception {
        throw new Exception("ResumeServiceImpl捕捉到异常");
    }
}
