package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Resume;


/**
 * @version V1.0
 * @author donghao
 * @date 2019/4/1 9:38
 * @className ResumeService
 * @packageName com.examonline.service
 * @description 简历业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ResumeService extends BaseService<Resume> {

    /**
     * @description 通过应聘者ID获取简历
     * @param applicantId
     * @return
     */
    public Resume getResumeByApplicantId(String applicantId);

    public Resume getResumeByApplicantAccount(String applicantAccount);
}
