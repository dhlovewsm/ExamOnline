package com.examonline.dao.mapper;

import com.examonline.common.base.BaseMapper;
import com.examonline.entity.Resume;

/**
 * @version V1.0
 * @date 2019/04/04
 * @author donghao
 * @descripiton 应聘者简历对应的mapper接口
 * @className ResumeMapper
 * @packageName com.examonline.dao.mapper
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ResumeMapper extends BaseMapper<Resume> {
    /**
     * 通过应聘人员登录时的用户名获取简历
     * @description 获取简历
     * @param applicantAccount
     * @return
     */
    public Resume getResumeByApplicantAccount(String applicantAccount);
}
