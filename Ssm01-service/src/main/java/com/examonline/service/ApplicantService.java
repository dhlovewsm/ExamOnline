package com.examonline.service;

import com.examonline.common.base.BaseService;
import com.examonline.entity.Applicant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version V1.0
 * @author donghao
 * @date 2019/04/03
 * @className ApplicantService
 * @packageName com.examonline.service
 * @description 应聘者业务接口
 * @copyright(C) www.bosssoft.com.cn
 */

public interface ApplicantService extends BaseService<Applicant> {

    /**
     * @description 通过应聘者用户名获取应聘者信息
     * @param applicantAccount
     * @return
     */
    public Applicant getApplicantByApplicantAccount(String applicantAccount);

    /**
     * @description 用于添加,判断是否存在
     * @param applicant
     * @return
     */
    public boolean ifExistsApplicant(Applicant applicant) throws Exception;

    /**
     * @description 用于更新,将请求的Applicant对象进行转换
     * @param requestApplicant
     * @return
     */
    public Applicant getRequestApplicant(Applicant requestApplicant);

    /**
     * @description 通过应聘者简历中的应聘部门名称获取应聘者
     * @param departmentId
     * @return
     */
    public List<Applicant> queryApplicantsByDepartmentId(Integer departmentId);

    /**
     * @description 获取所有应聘者
     * @return
     */
    public List<Applicant> getAll();
}